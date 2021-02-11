package edu.nyu.sdg.penalties.controller;

import static java.math.BigDecimal.ZERO;
import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.AppConstants;
import edu.nyu.sdg.penalties.model.CarbonLimits;
import edu.nyu.sdg.penalties.model.LL84Data;
import edu.nyu.sdg.penalties.model.Penalties;
import java.math.BigDecimal;

public final class FlowOrchestrator {

  private final CarbonLimitCalculator carbonLimitCalculator;
  private final EnergyConsumptionCalculator energyConsumptionCalculator;

  public FlowOrchestrator(
      CarbonLimitCalculator carbonLimitCalculator,
      EnergyConsumptionCalculator energyConsumptionCalculator) {
    this.carbonLimitCalculator =
        requireNonNull(carbonLimitCalculator, "carbonLimitCalculator is required and missing.");
    this.energyConsumptionCalculator =
        requireNonNull(
            energyConsumptionCalculator, "energyConsumptionCalculator is required and missing.");
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
   * @return penalties for excess carbon emission
   */
  public Penalties calculatePenalties(LL84Data ll84Data) {
    requireNonNull(ll84Data, "ll84Data is required and missing.");

    CarbonLimits carbonLimits = carbonLimitCalculator.calculateCarbonLimit(ll84Data);
    BigDecimal emissions = energyConsumptionCalculator.calculateCarbonEmission(ll84Data);

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

    return Penalties.newBuilder()
        .withPhase1Penalties(phase1Penalty)
        .withPhase2Penalties(phase2Penalty)
        .build();
  }
}
