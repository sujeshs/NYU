package edu.nyu.sdg.penalties.config;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.dao.contract.LookupDAO;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LookupConfig {

  @Bean
  @Qualifier("energy-ghg-coeff")
  Map<String, BigDecimal> loadEnergysrcGHCoeffData(LookupDAO lookupDAO) {
    requireNonNull(lookupDAO, "lookupDAO is required and missing.");

    return lookupDAO.getEnergysrcGHCoeffData();
  }

  @Bean
  @Qualifier("occupancy-spaceuse")
  Map<String, String> loadOccupancySpaceUseData(LookupDAO lookupDAO) {
    requireNonNull(lookupDAO, "lookupDAO is required and missing.");

    return lookupDAO.getLL84SpaceOccupancyGrpData();
  }

  @Bean
  @Qualifier("carbon-limit")
  Map<String, Map<String, BigDecimal>> loadCarbonLimitData(LookupDAO lookupDAO) {
    requireNonNull(lookupDAO, "lookupDAO is required and missing.");

    return lookupDAO.getCarbonLimitData();
  }
}
