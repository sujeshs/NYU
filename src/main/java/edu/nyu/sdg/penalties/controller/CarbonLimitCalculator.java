package edu.nyu.sdg.penalties.controller;

import com.google.common.collect.ImmutableList;
import edu.nyu.sdg.penalties.model.CarbonLimits;
import edu.nyu.sdg.penalties.model.LL84Data;
import edu.nyu.sdg.penalties.model.LookupData;
import edu.nyu.sdg.penalties.model.OccupancyGroupInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static edu.nyu.sdg.penalties.AppConstants.*;
import static java.util.Objects.*;

public class CarbonLimitCalculator {

    private final LookupData lookupData;

    public CarbonLimitCalculator(LookupData lookupData) {
        this.lookupData = lookupData;
    }

    public CarbonLimits calculateCarbonLimit(LL84Data ll84Data) {
        requireNonNull(ll84Data, "ll84Data is required and missing.");

        List<OccupancyGroupInfo> occupancyGroupInfos = constructOccupancyGroupInfo(ll84Data);

        BigDecimal totalCarbonLimitPhase1 = BigDecimal.valueOf(0);
        BigDecimal totalCarbonLimitPhase2 = BigDecimal.valueOf(0);

        for (OccupancyGroupInfo occupancyGroupInfo : occupancyGroupInfos) {
            BigDecimal carbonLimitPhase1 = occupancyGroupInfo.getCarbonLimitPhase1().multiply(occupancyGroupInfo.getOccupancyGroupArea()).divide(BigDecimal.valueOf(1000));
            BigDecimal carbonLimitPhase2 = occupancyGroupInfo.getCarbonLimitPhase2().multiply(occupancyGroupInfo.getOccupancyGroupArea()).divide(BigDecimal.valueOf(1000));

            totalCarbonLimitPhase1 = totalCarbonLimitPhase1.add(carbonLimitPhase1);
            totalCarbonLimitPhase2 = totalCarbonLimitPhase2.add(carbonLimitPhase2);
        }

        return CarbonLimits.newBuilder().withCarbonLimitPhase1(totalCarbonLimitPhase1).withCarbonLimitPhase2(totalCarbonLimitPhase2).build();
    }


    private List<OccupancyGroupInfo> constructOccupancyGroupInfo(LL84Data ll84Data) {

        requireNonNull(ll84Data, "ll84Data is required and missing.");
        requireNonNull(lookupData.getLl84ll97(), "lookupData.getLl84ll97() is required and missing.");
        requireNonNull(lookupData.getLl97CarbonLimit(), "lookupData.getLl97CarbonLimit() is required and missing.");

        Map<String, String> ll84Toll97Mapping = lookupData.getLl84ll97();

        String occupancyGrp1 = ll84Toll97Mapping.get(ll84Data.getSpaceUse1());
        String occupancyGrp2 = ll84Toll97Mapping.get(ll84Data.getSpaceUse2());
        String occupancyGrp3 = ll84Toll97Mapping.get(ll84Data.getSpaceUse3());

        Map<String, Map<String, BigDecimal>> ll97CarbonLimit = lookupData.getLl97CarbonLimit();
        Map<String, BigDecimal> carbonLimitsGrp1 = ll97CarbonLimit.get(occupancyGrp1);
        Map<String, BigDecimal> carbonLimitsGrp2 = ll97CarbonLimit.get(occupancyGrp2);
        Map<String, BigDecimal> carbonLimitsGrp3 = ll97CarbonLimit.get(occupancyGrp3);

        OccupancyGroupInfo occupancyGroupInfo1 = OccupancyGroupInfo.newBuilder()
                .withOccupancyGroup(occupancyGrp1)
                .withCarbonLimitPhase1(carbonLimitsGrp1.get(PHASE1))
                .withCarbonLimitPhase2(carbonLimitsGrp1.get(PHASE2))
                .withOccupancyGroupArea(ll84Data.getSpaceUse1FloorArea())
                .build();

        OccupancyGroupInfo occupancyGroupInfo2 = OccupancyGroupInfo.newBuilder()
                .withOccupancyGroup(occupancyGrp2)
                .withCarbonLimitPhase1(carbonLimitsGrp2.get(PHASE1))
                .withCarbonLimitPhase2(carbonLimitsGrp2.get(PHASE2))
                .withOccupancyGroupArea(ll84Data.getSpaceUse2FloorArea())
                .build();

        OccupancyGroupInfo occupancyGroupInfo3 = OccupancyGroupInfo.newBuilder()
                .withOccupancyGroup(occupancyGrp3)
                .withCarbonLimitPhase1(carbonLimitsGrp3.get(PHASE1))
                .withCarbonLimitPhase2(carbonLimitsGrp3.get(PHASE2))
                .withOccupancyGroupArea(ll84Data.getSpaceUse3FloorArea())
                .build();

        return ImmutableList.of(occupancyGroupInfo1, occupancyGroupInfo2, occupancyGroupInfo3);

    }

}
