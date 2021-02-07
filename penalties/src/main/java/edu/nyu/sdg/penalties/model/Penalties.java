package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Penalties {

  /** Phase 1 penalties (2024-2029) */
  private final BigDecimal phase1Penalties;

  /** Phase 2 penalties (2030-2034) */
  private final BigDecimal phase2Penalties;

  private Penalties(Builder builder) {
    phase1Penalties = builder.phase1Penalties;
    phase2Penalties = builder.phase2Penalties;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(Penalties copy) {
    Builder builder = new Builder();
    builder.phase1Penalties = copy.getPhase1Penalties();
    builder.phase2Penalties = copy.getPhase2Penalties();
    return builder;
  }

  public BigDecimal getPhase1Penalties() {
    return phase1Penalties;
  }

  public BigDecimal getPhase2Penalties() {
    return phase2Penalties;
  }

  public static final class Builder {
    private BigDecimal phase1Penalties;
    private BigDecimal phase2Penalties;

    private Builder() {}

    public Builder withPhase1Penalties(BigDecimal val) {
      phase1Penalties = val;
      return this;
    }

    public Builder withPhase2Penalties(BigDecimal val) {
      phase2Penalties = val;
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
        && Objects.equals(phase2Penalties, penalties.phase2Penalties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phase1Penalties, phase2Penalties);
  }

  @Override
  public String toString() {
    return "Penalties{"
        + "phase1Penalties="
        + phase1Penalties
        + ", phase2Penalties="
        + phase2Penalties
        + '}';
  }
}
