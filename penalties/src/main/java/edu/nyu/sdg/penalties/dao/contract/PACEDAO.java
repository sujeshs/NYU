package edu.nyu.sdg.penalties.dao.contract;

import edu.nyu.sdg.penalties.model.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/** Contracts for the different lookup operations */
public interface PACEDAO {

  /** @return the energy source - greenhouse coefficient mapping */
  Map<String, BigDecimal> getEnergysrcGHCoeffData();

  /** @return the carbon limit for the occupancy group for phase1(2024-29) and phase2(2030-34) */
  Map<String, Map<String, BigDecimal>> getCarbonLimitData();

  /** @return the space use - occupancy group mapping */
  Map<String, String> getLL84SpaceOccupancyGrpData();

  void writePenaltyInfo(LL84FeedData ll84FeedData, DerivedVariables derivedVariables);

  void writeLL84Data(LL84FeedData ll84FeedData);

  void writeAcrisData(LL84FeedData ll84FeedData);

  void writeNYCHAData(NYCHAFeedData nychaFeedData);

  void writeRentStabilizedUnitsData(RentStabilizedBBLFeedData rentStabilizedBBLFeedData);

  void writeSoanaData(SoanaFeedData soanaFeedData);

  void writeQCTData(QCTFeedData qctFeedData);

  List<LL84FeedData> readLL84Data();

  void deleteLL84Data(LL84FeedData ll84FeedData);
}
