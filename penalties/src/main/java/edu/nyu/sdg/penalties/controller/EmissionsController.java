package edu.nyu.sdg.penalties.controller;

import static edu.nyu.sdg.penalties.AppConstants.CURRENCY_FORMAT;
import static java.math.BigDecimal.*;

import edu.nyu.sdg.penalties.AppConstants;
import edu.nyu.sdg.penalties.model.CarbonLimits;
import edu.nyu.sdg.penalties.model.LL84Data;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmissionsController {

  private final CarbonLimitCalculator carbonLimitCalculator;
  private final EnergyConsumptionCalculator energyConsumptionCalculator;

  public EmissionsController(
      CarbonLimitCalculator carbonLimitCalculator,
      EnergyConsumptionCalculator energyConsumptionCalculator) {
    this.carbonLimitCalculator = carbonLimitCalculator;
    this.energyConsumptionCalculator = energyConsumptionCalculator;
  }

  @PostMapping("/penalty")
  public String getCarbonLimits(@RequestBody LL84Data ll84Data) {

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

    return "Phase 1 penalty "
        + CURRENCY_FORMAT.format(phase1Penalty)
        + " Phase 2 penalty "
        + CURRENCY_FORMAT.format(phase2Penalty);
  }
}
