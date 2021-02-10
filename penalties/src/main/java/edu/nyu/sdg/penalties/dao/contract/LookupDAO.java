package edu.nyu.sdg.penalties.dao.contract;

import java.math.BigDecimal;
import java.util.Map;

/** Contracts for the different lookup operations */
public interface LookupDAO {

  /** @return the energy source - greenhouse coefficient mapping */
  Map<String, BigDecimal> getEnergysrcGHCoeffData();

  /** @return the carbon limit for the occupancy group for phase1(2024-29) and phase2(2030-34) */
  Map<String, Map<String, BigDecimal>> getCarbonLimitData();

  /** @return the space use - occupancy group mapping */
  Map<String, String> getLL84SpaceOccupancyGrpData();
}
