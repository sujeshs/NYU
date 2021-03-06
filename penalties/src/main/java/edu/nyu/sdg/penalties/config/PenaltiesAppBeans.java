package edu.nyu.sdg.penalties.config;

import static java.util.Objects.*;

import edu.nyu.sdg.penalties.controller.CarbonLimitCalculator;
import edu.nyu.sdg.penalties.controller.EnergyConsumptionCalculator;
import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.dao.contract.SDGDataInsertDAO;
import edu.nyu.sdg.penalties.inputstream.file.*;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PenaltiesAppBeans {

  @Bean
  FlowOrchestrator flowOrchestrator(
      CarbonLimitCalculator carbonLimitCalculator,
      EnergyConsumptionCalculator energyConsumptionCalculator,
      SDGDataInsertDAO sdgDataInsertDAO) {
    requireNonNull(carbonLimitCalculator, "carbonLimitCalculator is required and missing.");
    requireNonNull(
        energyConsumptionCalculator, "energyConsumptionCalculator is required and missing.");
    requireNonNull(sdgDataInsertDAO, "sdgDataInsertDAO is required and missing.");

    return new FlowOrchestrator(
        carbonLimitCalculator, energyConsumptionCalculator, sdgDataInsertDAO);
  }

  @Bean
  CarbonLimitCalculator carbonLimitCalculator(
      @Qualifier("carbon-limit") Map<String, Map<String, BigDecimal>> carbonLimitData,
      @Qualifier("occupancy-spaceuse") Map<String, String> occupancySpaceUseData) {
    requireNonNull(carbonLimitData, "carbonLimitData is required and missing.");
    requireNonNull(occupancySpaceUseData, "occupancySpaceUseData is required and missing.");

    return new CarbonLimitCalculator(carbonLimitData, occupancySpaceUseData);
  }

  @Bean
  EnergyConsumptionCalculator energyConsumptionCalculator(
      @Qualifier("energy-ghg-coeff") Map<String, BigDecimal> energysrcGHCoeffData) {
    requireNonNull(energysrcGHCoeffData, "energysrcGHCoeffData is required and missing.");

    return new EnergyConsumptionCalculator(energysrcGHCoeffData);
  }

  @Bean
  CleanUpLL84CSVFile cleanUpLL84CSVFile() {
    return new CleanUpLL84CSVFile();
  }

  @Bean
  LL84CSVFileLoader ll84FileLoader(FlowOrchestrator flowOrchestrator) {
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new LL84CSVFileLoader(flowOrchestrator);
  }

  @Bean
  NYCHAFileLoader nychaFileLoader(FlowOrchestrator flowOrchestrator) {
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new NYCHAFileLoader(flowOrchestrator);
  }

  @Bean
  RentStabilizedFileLoader rentStabilizedFileLoader(FlowOrchestrator flowOrchestrator) {
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new RentStabilizedFileLoader(flowOrchestrator);
  }

  @Bean
  SOANAFileLoader soanaFileLoader(FlowOrchestrator flowOrchestrator) {
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new SOANAFileLoader(flowOrchestrator);
  }

}
