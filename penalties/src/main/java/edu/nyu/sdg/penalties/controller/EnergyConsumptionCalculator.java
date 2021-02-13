package edu.nyu.sdg.penalties.controller;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.model.LL84FeedData;
import java.math.BigDecimal;
import java.util.Map;

public final class EnergyConsumptionCalculator {

  private final Map<String, BigDecimal> energysrcGHCoeffData;

  public EnergyConsumptionCalculator(Map<String, BigDecimal> energysrcGHCoeffData) {
    this.energysrcGHCoeffData = energysrcGHCoeffData;
  }

  public BigDecimal calculateCarbonEmission(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84Data is required and missing.");

    BigDecimal carbonEmission = BigDecimal.valueOf(0);

    // TODO add all possible energy sources
    BigDecimal emissionFromDistrictSteam =
        ll84FeedData.getDistrictSteamUse() == null
            ? BigDecimal.valueOf(0)
            : ll84FeedData.getDistrictSteamUse().multiply(energysrcGHCoeffData.get("DistrictSteam"));
    BigDecimal emissionFromFuelOil2 =
        ll84FeedData.getFuelOil2Use() == null
            ? BigDecimal.valueOf(0)
            : ll84FeedData.getFuelOil2Use().multiply(energysrcGHCoeffData.get("FuelOil2"));
    BigDecimal emissionFromFuelOil4 =
        ll84FeedData.getFuelOil4Use() == null
            ? BigDecimal.valueOf(0)
            : ll84FeedData.getFuelOil4Use().multiply(energysrcGHCoeffData.get("FuelOil4"));
    BigDecimal emissionFromNaturalGas =
        ll84FeedData.getNaturalGasUsekBTU() == null
            ? BigDecimal.valueOf(0)
            : ll84FeedData.getNaturalGasUsekBTU().multiply(energysrcGHCoeffData.get("Natural-Gas"));
    BigDecimal emissionFromElectricity =
        ll84FeedData.getElectricityGridPurchasekWh() == null
            ? BigDecimal.valueOf(0)
            : ll84FeedData
                .getElectricityGridPurchasekWh()
                .multiply(energysrcGHCoeffData.get("Utility-Electricity"));

    return carbonEmission
        .add(emissionFromDistrictSteam)
        .add(emissionFromFuelOil2)
        .add(emissionFromFuelOil4)
        .add(emissionFromNaturalGas)
        .add(emissionFromElectricity);
  }
}
