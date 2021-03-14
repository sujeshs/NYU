package edu.nyu.sdg.penalties.controller;

import static java.math.BigDecimal.ZERO;
import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.AppConstants;
import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import edu.nyu.sdg.penalties.model.*;
import java.math.BigDecimal;

public final class FlowOrchestrator {

  private final CarbonLimitCalculator carbonLimitCalculator;
  private final EnergyConsumptionCalculator energyConsumptionCalculator;
  private final PACEDAO PACEDAO;

  public FlowOrchestrator(
      CarbonLimitCalculator carbonLimitCalculator,
      EnergyConsumptionCalculator energyConsumptionCalculator,
      PACEDAO PACEDAO) {
    this.carbonLimitCalculator =
        requireNonNull(carbonLimitCalculator, "carbonLimitCalculator is required and missing.");
    this.energyConsumptionCalculator =
        requireNonNull(
            energyConsumptionCalculator, "energyConsumptionCalculator is required and missing.");
    this.PACEDAO =
        requireNonNull(PACEDAO, "sdgDataInsertDAO is required and missing.");
  }

  /**
   * Caculates penalties for excess carbon emission
   *
   * <p>Step 1 : Calculate carbon limit according to occupancy group
   *
   * <p>Step 2 : Calculate total emissions using energy consumption & Greenhouse gas coefficient
   *
   * <p>Step 3 : Calculate penalty at the defined rate for emissions over the limit
   *
   * <p>Step 4 : Insert data into underlying datastore
   *
   * @return penalties for excess carbon emission
   */
  public Penalties calculatePenalties(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84Data is required and missing.");

    CarbonLimits carbonLimits = carbonLimitCalculator.calculateCarbonLimit(ll84FeedData);
    BigDecimal emissions = energyConsumptionCalculator.calculateCarbonEmission(ll84FeedData);

    BigDecimal phase1ExcessEmission = emissions.subtract(carbonLimits.getCarbonLimitPhase1());
    BigDecimal phase2ExcessEmission = emissions.subtract(carbonLimits.getCarbonLimitPhase2());

    BigDecimal phase1Penalty =
        phase1ExcessEmission.compareTo(ZERO) == 1
            ? phase1ExcessEmission.multiply(AppConstants.PENALTY_PER_TON)
            : ZERO;
    BigDecimal phase2Penalty =
        phase2ExcessEmission.compareTo(ZERO) == 1
            ? phase2ExcessEmission.multiply(AppConstants.PENALTY_PER_TON)
            : ZERO;

    Penalties calculatedPenalties =
        Penalties.newBuilder()
            .withPhase1Penalties(phase1Penalty)
            .withPhase2Penalties(phase2Penalty)
            .withPhase1PenaltiesUSD(AppConstants.CURRENCY_FORMAT.format(phase1Penalty))
            .withPhase2PenaltiesUSD(AppConstants.CURRENCY_FORMAT.format(phase2Penalty))
            .build();

    DerivedVariables derivedVariables =
        DerivedVariables.newBuilder()
            .withPenalties(calculatedPenalties)
            .withCarbonLimits(carbonLimits)
            .withTotalActualEmissions(emissions)
            .withExcessEmissionPhase1(phase1ExcessEmission)
            .withExcessEmissionPhase2(phase2ExcessEmission)
            .build();

    PACEDAO.writePenaltyInfo(ll84FeedData, derivedVariables);

    return calculatedPenalties;
  }

  public void loadNYCHAData(NYCHAFeedData nychaFeedData) {
    requireNonNull(nychaFeedData, "nychaFeedData is required and missing.");

    PACEDAO.writeNYCHAData(nychaFeedData);
  }

  public void loadSoanaData(SoanaFeedData soanaFeedData) {
    requireNonNull(soanaFeedData, "soanaFeedData is required and missing.");

    PACEDAO.writeSoanaData(soanaFeedData);
  }

  public void loadRentStabilizedUnitsData(RentStabilizedBBLFeedData rentStabilizedBBLFeedData) {
    requireNonNull(rentStabilizedBBLFeedData, "rentStabilizedBBLFeedData is required and missing.");

    PACEDAO.writeRentStabilizedUnitsData(rentStabilizedBBLFeedData);
  }

  public void loadLL84AndAcrisData(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84FeedData is required and missing.");

    PACEDAO.writeLL84Data(ll84FeedData);
    PACEDAO.writeAcrisData(ll84FeedData);
  }
}
