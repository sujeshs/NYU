package edu.nyu.sdg.penalties.config;

import static java.util.Objects.*;

import edu.nyu.sdg.penalties.controller.CarbonLimitCalculator;
import edu.nyu.sdg.penalties.controller.EnergyConsumptionCalculator;
import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.model.LookupData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PenaltiesAppBeans {

  @Bean
  FlowOrchestrator flowOrchestrator() {
    return new FlowOrchestrator();
  }

  @Bean
  CarbonLimitCalculator carbonLimitCalculator(LookupData lookupData) {
    requireNonNull(lookupData, "lookupData is required and missing.");

    return new CarbonLimitCalculator(lookupData);
  }

  @Bean
  EnergyConsumptionCalculator energyConsumptionCalculator(LookupData lookupData) {
    requireNonNull(lookupData, "lookupData is required and missing.");

    return new EnergyConsumptionCalculator(lookupData);
  }
}
