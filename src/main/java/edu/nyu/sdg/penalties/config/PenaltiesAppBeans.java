package edu.nyu.sdg.penalties.config;

import edu.nyu.sdg.penalties.controller.CarbonLimitCalculator;
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
        return new CarbonLimitCalculator(lookupData);
    }

}
