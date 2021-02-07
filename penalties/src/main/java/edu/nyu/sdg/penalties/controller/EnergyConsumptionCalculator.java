package edu.nyu.sdg.penalties.controller;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.model.LL84Data;
import edu.nyu.sdg.penalties.model.LookupData;
import java.math.BigDecimal;
import java.util.Map;

public final class EnergyConsumptionCalculator {

  private final LookupData lookupData;

  public EnergyConsumptionCalculator(LookupData lookupData) {
    this.lookupData = lookupData;
  }

  public BigDecimal calculateCarbonEmission(LL84Data ll84Data) {
    requireNonNull(ll84Data, "ll84Data is required and missing.");
    requireNonNull(
        lookupData.getEnergysrcGHCoeff(),
        "lookupData.getEnergysrcGHCoeff() is required and missing.");

    Map<String, BigDecimal> energysrcGHCoeff = lookupData.getEnergysrcGHCoeff();

    BigDecimal carbonEmission = BigDecimal.valueOf(0);

    // TODO add all possible energy sources
    BigDecimal emissionFromDiesel =
        ll84Data.getDiesel2Use().multiply(energysrcGHCoeff.get("Diesel"));
    BigDecimal emissionFromFuelOil2 =
        ll84Data.getFuelOil2Use().multiply(energysrcGHCoeff.get("FuelOil2"));
    BigDecimal emissionFromNaturalGas =
        ll84Data.getNaturalGasUse().multiply(energysrcGHCoeff.get("Natural-Gas"));

    return carbonEmission
        .add(emissionFromDiesel)
        .add(emissionFromFuelOil2)
        .add(emissionFromNaturalGas);
  }
}
