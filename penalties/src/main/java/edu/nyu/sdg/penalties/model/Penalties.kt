package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public final class Penalties {

  /** Phase 1 penalties (2024-2029) */
  private final BigDecimal phase1Penalties;

  /** Phase 2 penalties (2030-2034) */
  private final BigDecimal phase2Penalties;

  /** USD String representation of Phase 1 penalties (2024-2029) */
  private final String phase1PenaltiesUSD;

  /** USD String representation of Phase 2 penalties (2030-2034) */
  private final String phase2PenaltiesUSD;

  private Penalties(Builder builder) {
    phase1Penalties = builder.phase1Penalties;
    phase2Penalties = builder.phase2Penalties;
    phase1PenaltiesUSD = builder.phase1PenaltiesUSD;
    phase2PenaltiesUSD = builder.phase2PenaltiesUSD;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(Penalties copy) {
    Builder builder = new Builder();
    builder.phase1Penalties = copy.getPhase1Penalties();
    builder.phase2Penalties = copy.getPhase2Penalties();
    builder.phase1PenaltiesUSD = copy.getPhase1PenaltiesUSD();
    builder.phase2PenaltiesUSD = copy.getPhase2PenaltiesUSD();
    return builder;
  }

  public BigDecimal getPhase1Penalties() {
    return phase1Penalties;
  }

  public BigDecimal getPhase2Penalties() {
    return phase2Penalties;
  }

  public String getPhase1PenaltiesUSD() {
    return phase1PenaltiesUSD;
  }

  public String getPhase2PenaltiesUSD() {
    return phase2PenaltiesUSD;
  }

  public static final class Builder {
    private BigDecimal phase1Penalties;
    private BigDecimal phase2Penalties;
    private String phase1PenaltiesUSD;
    private String phase2PenaltiesUSD;

    private Builder() {}

    public Builder withPhase1Penalties(BigDecimal val) {
      phase1Penalties = val;
      return this;
    }

    public Builder withPhase2Penalties(BigDecimal val) {
      phase2Penalties = val;
      return this;
    }

    public Builder withPhase1PenaltiesUSD(String val) {
      phase1PenaltiesUSD = val;
      return this;
    }

    public Builder withPhase2PenaltiesUSD(String val) {
      phase2PenaltiesUSD = val;
      return this;
    }

    public Penalties build() {
      return new Penalties(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Penalties penalties = (Penalties) o;
    return Objects.equals(phase1Penalties, penalties.phase1Penalties)
        && Objects.equals(phase2Penalties, penalties.phase2Penalties)
        && Objects.equals(phase1PenaltiesUSD, penalties.phase1PenaltiesUSD)
        && Objects.equals(phase2PenaltiesUSD, penalties.phase2PenaltiesUSD);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phase1Penalties, phase2Penalties, phase1PenaltiesUSD, phase2PenaltiesUSD);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Penalties.class.getSimpleName() + "[", "]")
        .add("phase1Penalties=" + phase1Penalties)
        .add("phase2Penalties=" + phase2Penalties)
        .add("phase1PenaltiesUSD='" + phase1PenaltiesUSD + "'")
        .add("phase2PenaltiesUSD='" + phase2PenaltiesUSD + "'")
        .toString();
  }
}
