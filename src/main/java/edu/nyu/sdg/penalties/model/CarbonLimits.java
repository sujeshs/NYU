package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class CarbonLimits {

    private final BigDecimal carbonLimitPhase1;
    private final BigDecimal carbonLimitPhase2;

    private CarbonLimits(Builder builder) {
        carbonLimitPhase1 = builder.carbonLimitPhase1;
        carbonLimitPhase2 = builder.carbonLimitPhase2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CarbonLimits copy) {
        Builder builder = new Builder();
        builder.carbonLimitPhase1 = copy.getCarbonLimitPhase1();
        builder.carbonLimitPhase2 = copy.getCarbonLimitPhase2();
        return builder;
    }

    public BigDecimal getCarbonLimitPhase1() {
        return carbonLimitPhase1;
    }

    public BigDecimal getCarbonLimitPhase2() {
        return carbonLimitPhase2;
    }

    public static final class Builder {
        private BigDecimal carbonLimitPhase1;
        private BigDecimal carbonLimitPhase2;

        private Builder() {
        }

        public Builder withCarbonLimitPhase1(BigDecimal val) {
            carbonLimitPhase1 = val;
            return this;
        }

        public Builder withCarbonLimitPhase2(BigDecimal val) {
            carbonLimitPhase2 = val;
            return this;
        }

        public CarbonLimits build() {
            return new CarbonLimits(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarbonLimits that = (CarbonLimits) o;
        return Objects.equals(carbonLimitPhase1, that.carbonLimitPhase1) &&
                Objects.equals(carbonLimitPhase2, that.carbonLimitPhase2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carbonLimitPhase1, carbonLimitPhase2);
    }

    @Override
    public String toString() {
        return "CarbonLimits{" +
                "carbonLimitPhase1=" + carbonLimitPhase1 +
                ", carbonLimitPhase2=" + carbonLimitPhase2 +
                '}';
    }
}
