package edu.nyu.sdg.penalties.config;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import java.util.Map;

import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LookupConfig {

  @Bean
  @Qualifier("energy-ghg-coeff")
  Map<String, BigDecimal> loadEnergysrcGHCoeffData(PACEDAO paceDAO) {
    requireNonNull(paceDAO, "paceDAO is required and missing.");

    return paceDAO.getEnergysrcGHCoeffData();
  }

  @Bean
  @Qualifier("occupancy-spaceuse")
  Map<String, String> loadOccupancySpaceUseData(PACEDAO paceDAO) {
    requireNonNull(paceDAO, "paceDAO is required and missing.");

    return paceDAO.getLL84SpaceOccupancyGrpData();
  }

  @Bean
  @Qualifier("carbon-limit")
  Map<String, Map<String, BigDecimal>> loadCarbonLimitData(PACEDAO paceDAO) {
    requireNonNull(paceDAO, "paceDAO is required and missing.");

    return paceDAO.getCarbonLimitData();
  }
}
