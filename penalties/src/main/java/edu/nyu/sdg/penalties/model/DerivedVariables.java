package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.StringJoiner;

public final class DerivedVariables {

  private final BigDecimal excessEmissionPhase1;
  private final BigDecimal excessEmissionPhase2;
  private final BigDecimal totalActualEmissions;
  private final CarbonLimits carbonLimits;
  private final Penalties penalties;

  private DerivedVariables(Builder builder) {
    excessEmissionPhase1 = builder.excessEmissionPhase1;
    excessEmissionPhase2 = builder.excessEmissionPhase2;
    totalActualEmissions = builder.totalActualEmissions;
    carbonLimits = builder.carbonLimits;
    penalties = builder.penalties;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(DerivedVariables copy) {
    Builder builder = new Builder();
    builder.excessEmissionPhase1 = copy.getExcessEmissionPhase1();
    builder.excessEmissionPhase2 = copy.getExcessEmissionPhase2();
    builder.totalActualEmissions = copy.getTotalActualEmissions();
    builder.carbonLimits = copy.getCarbonLimits();
    builder.penalties = copy.getPenalties();
    return builder;
  }

  public BigDecimal getExcessEmissionPhase1() {
    return excessEmissionPhase1;
  }

  public BigDecimal getExcessEmissionPhase2() {
    return excessEmissionPhase2;
  }

  public BigDecimal getTotalActualEmissions() {
    return totalActualEmissions;
  }

  public CarbonLimits getCarbonLimits() {
    return carbonLimits;
  }

  public Penalties getPenalties() {
    return penalties;
  }

  public static final class Builder {
    private BigDecimal excessEmissionPhase1;
    private BigDecimal excessEmissionPhase2;
    private BigDecimal totalActualEmissions;
    private CarbonLimits carbonLimits;
    private Penalties penalties;

    private Builder() {
    }

    public Builder withExcessEmissionPhase1(BigDecimal val) {
      excessEmissionPhase1 = val;
      return this;
    }

    public Builder withExcessEmissionPhase2(BigDecimal val) {
      excessEmissionPhase2 = val;
      return this;
    }

    public Builder withTotalActualEmissions(BigDecimal val) {
      totalActualEmissions = val;
      return this;
    }

    public Builder withCarbonLimits(CarbonLimits val) {
      carbonLimits = val;
      return this;
    }

    public Builder withPenalties(Penalties val) {
      penalties = val;
      return this;
    }

    public DerivedVariables build() {
      return new DerivedVariables(this);
    }
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DerivedVariables.class.getSimpleName() + "[", "]")
      .add("excessEmissionPhase1=" + excessEmissionPhase1)
      .add("excessEmissionPhase2=" + excessEmissionPhase2)
      .add("totalActualEmissions=" + totalActualEmissions)
      .add("carbonLimits=" + carbonLimits)
      .add("penalties=" + penalties)
      .toString();
  }
}
