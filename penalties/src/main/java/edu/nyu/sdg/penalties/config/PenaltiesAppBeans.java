package edu.nyu.sdg.penalties.config;

import static java.util.Objects.*;

import edu.nyu.sdg.penalties.controller.CarbonLimitCalculator;
import edu.nyu.sdg.penalties.controller.EnergyConsumptionCalculator;
import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Map;

@Configuration
public class PenaltiesAppBeans {

  @Bean
  FlowOrchestrator flowOrchestrator() {
    return new FlowOrchestrator();
  }

  @Bean
  CarbonLimitCalculator carbonLimitCalculator( @Qualifier("carbon-limit") Map<String, Map<String, BigDecimal>> carbonLimitData,
                                               @Qualifier("occupancy-spaceuse") Map<String, String> occupancySpaceUseData) {
    requireNonNull(carbonLimitData, "carbonLimitData is required and missing.");
    requireNonNull(occupancySpaceUseData, "occupancySpaceUseData is required and missing.");

    return new CarbonLimitCalculator(carbonLimitData, occupancySpaceUseData );
  }

  @Bean
  EnergyConsumptionCalculator energyConsumptionCalculator( @Qualifier("energy-ghg-coeff") Map<String, BigDecimal> energysrcGHCoeffData) {
    requireNonNull(energysrcGHCoeffData, "energysrcGHCoeffData is required and missing.");

    return new EnergyConsumptionCalculator(energysrcGHCoeffData);
  }

}
