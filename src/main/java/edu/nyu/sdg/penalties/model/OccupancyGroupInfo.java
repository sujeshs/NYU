package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Holds key information about the occupancy groups in the property
 */
public final class OccupancyGroupInfo {

    private final String occupancyGroup;
    private final String spaceUse;
    private final BigDecimal occupancyGroupArea;
    private final BigDecimal carbonLimitPhase1;
    private final BigDecimal carbonLimitPhase2;

    private OccupancyGroupInfo(Builder builder) {
        occupancyGroup = builder.occupancyGroup;
        spaceUse = builder.spaceUse;
        occupancyGroupArea = builder.occupancyGroupArea;
        carbonLimitPhase1 = builder.carbonLimitPhase1;
        carbonLimitPhase2 = builder.carbonLimitPhase2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(OccupancyGroupInfo copy) {
        Builder builder = new Builder();
        builder.occupancyGroup = copy.getOccupancyGroup();
        builder.spaceUse = copy.getSpaceUse();
        builder.occupancyGroupArea = copy.getOccupancyGroupArea();
        builder.carbonLimitPhase1 = copy.getCarbonLimitPhase1();
        builder.carbonLimitPhase2 = copy.getCarbonLimitPhase2();
        return builder;
    }

    public String getOccupancyGroup() {
        return occupancyGroup;
    }

    public String getSpaceUse() {
        return spaceUse;
    }

    public BigDecimal getOccupancyGroupArea() {
        return occupancyGroupArea;
    }

    public BigDecimal getCarbonLimitPhase1() {
        return carbonLimitPhase1;
    }

    public BigDecimal getCarbonLimitPhase2() {
        return carbonLimitPhase2;
    }

    public static final class Builder {
        private String occupancyGroup;
        private String spaceUse;
        private BigDecimal occupancyGroupArea;
        private BigDecimal carbonLimitPhase1;
        private BigDecimal carbonLimitPhase2;

        private Builder() {
        }

        public Builder withOccupancyGroup(String val) {
            occupancyGroup = val;
            return this;
        }

        public Builder withSpaceUse(String val) {
            spaceUse = val;
            return this;
        }

        public Builder withOccupancyGroupArea(BigDecimal val) {
            occupancyGroupArea = val;
            return this;
        }

        public Builder withCarbonLimitPhase1(BigDecimal val) {
            carbonLimitPhase1 = val;
            return this;
        }

        public Builder withCarbonLimitPhase2(BigDecimal val) {
            carbonLimitPhase2 = val;
            return this;
        }

        public OccupancyGroupInfo build() {
            return new OccupancyGroupInfo(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccupancyGroupInfo that = (OccupancyGroupInfo) o;
        return Objects.equals(occupancyGroup, that.occupancyGroup) &&
                Objects.equals(spaceUse, that.spaceUse) &&
                Objects.equals(occupancyGroupArea, that.occupancyGroupArea) &&
                Objects.equals(carbonLimitPhase1, that.carbonLimitPhase1) &&
                Objects.equals(carbonLimitPhase2, that.carbonLimitPhase2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(occupancyGroup, spaceUse, occupancyGroupArea, carbonLimitPhase1, carbonLimitPhase2);
    }

    @Override
    public String toString() {
        return "OccupancyGroupInfo{" +
                "occupancyGroup='" + occupancyGroup + '\'' +
                ", spaceUse='" + spaceUse + '\'' +
                ", occupancyGroupArea=" + occupancyGroupArea +
                ", carbonLimitPhase1=" + carbonLimitPhase1 +
                ", carbonLimitPhase2=" + carbonLimitPhase2 +
                '}';
    }
}
