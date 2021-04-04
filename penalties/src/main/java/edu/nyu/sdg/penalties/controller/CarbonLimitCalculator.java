package edu.nyu.sdg.penalties.controller;

import static edu.nyu.sdg.penalties.AppConstants.*;
import static java.util.Objects.*;

import com.google.common.collect.ImmutableList;
import edu.nyu.sdg.penalties.model.CarbonLimits;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import edu.nyu.sdg.penalties.model.OccupancyGroupInfo;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public final class CarbonLimitCalculator {

  private final Map<String, Map<String, BigDecimal>> carbonLimitData;
  private final Map<String, String> occupancySpaceUseData;

  public CarbonLimitCalculator(
      Map<String, Map<String, BigDecimal>> carbonLimitData,
      Map<String, String> occupancySpaceUseData) {
    this.carbonLimitData =
        requireNonNull(carbonLimitData, "carbonLimitData is required and missing.");
    this.occupancySpaceUseData =
        requireNonNull(occupancySpaceUseData, "occupancySpaceUseData is required and missing.");
  }

  public CarbonLimits calculateCarbonLimit(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84Data is required and missing.");

    List<OccupancyGroupInfo> occupancyGroupInfos = constructOccupancyGroupInfo(ll84FeedData);

    BigDecimal totalCarbonLimitPhase1 = BigDecimal.valueOf(0);
    BigDecimal totalCarbonLimitPhase2 = BigDecimal.valueOf(0);

    for (OccupancyGroupInfo occupancyGroupInfo : occupancyGroupInfos) {
      BigDecimal carbonLimitPhase1 =
          occupancyGroupInfo
              .getCarbonLimitPhase1()
              .multiply(occupancyGroupInfo.getOccupancyGroupArea())
              .divide(BigDecimal.valueOf(1000));
      BigDecimal carbonLimitPhase2 =
          occupancyGroupInfo
              .getCarbonLimitPhase2()
              .multiply(occupancyGroupInfo.getOccupancyGroupArea())
              .divide(BigDecimal.valueOf(1000));

      totalCarbonLimitPhase1 = totalCarbonLimitPhase1.add(carbonLimitPhase1);
      totalCarbonLimitPhase2 = totalCarbonLimitPhase2.add(carbonLimitPhase2);
    }

    return new CarbonLimits(totalCarbonLimitPhase1,totalCarbonLimitPhase2);
  }

  private List<OccupancyGroupInfo> constructOccupancyGroupInfo(LL84FeedData ll84FeedData) {

    requireNonNull(ll84FeedData, "ll84Data is required and missing.");

    String occupancyGrp1 = occupancySpaceUseData.get(ll84FeedData.getLargestPropertyUseType());
    String occupancyGrp2 =
        occupancySpaceUseData.get(ll84FeedData.getSecondLargestPropertyUseType());
    String occupancyGrp3 = occupancySpaceUseData.get(ll84FeedData.getThirdLargestPropertyUseType());

    Map<String, BigDecimal> carbonLimitsGrp1 = carbonLimitData.get(occupancyGrp1);
    Map<String, BigDecimal> carbonLimitsGrp2 = carbonLimitData.get(occupancyGrp2);
    Map<String, BigDecimal> carbonLimitsGrp3 = carbonLimitData.get(occupancyGrp3);

    OccupancyGroupInfo occupancyGroupInfo1 =
        OccupancyGroupInfo.newBuilder()
            .withOccupancyGroup(occupancyGrp1)
            .withCarbonLimitPhase1(getNullSafeCarbonLimit(carbonLimitsGrp1, PHASE1))
            .withCarbonLimitPhase2(getNullSafeCarbonLimit(carbonLimitsGrp1, PHASE2))
            .withOccupancyGroupArea(ll84FeedData.getLargestPropertyUseTypeGrossFloorArea())
            .build();

    OccupancyGroupInfo occupancyGroupInfo2 =
        OccupancyGroupInfo.newBuilder()
            .withOccupancyGroup(occupancyGrp2)
            .withCarbonLimitPhase1(getNullSafeCarbonLimit(carbonLimitsGrp2, PHASE1))
            .withCarbonLimitPhase2(getNullSafeCarbonLimit(carbonLimitsGrp2, PHASE2))
            .withOccupancyGroupArea(ll84FeedData.getSecondLargestPropertyUseTypeGrossFloorArea())
            .build();

    OccupancyGroupInfo occupancyGroupInfo3 =
        OccupancyGroupInfo.newBuilder()
            .withOccupancyGroup(occupancyGrp3)
            .withCarbonLimitPhase1(getNullSafeCarbonLimit(carbonLimitsGrp3, PHASE1))
            .withCarbonLimitPhase2(getNullSafeCarbonLimit(carbonLimitsGrp3, PHASE2))
            .withOccupancyGroupArea(ll84FeedData.getThirdLargestPropertyUseTypeGrossFloorArea())
            .build();

    return ImmutableList.of(occupancyGroupInfo1, occupancyGroupInfo2, occupancyGroupInfo3);
  }

  private BigDecimal getNullSafeCarbonLimit(Map<String, BigDecimal> carbonLimits, String key) {
    return carbonLimits == null ? BigDecimal.ZERO : carbonLimits.get(key);
  }
}
