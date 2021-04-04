package edu.nyu.sdg.penalties.model

import java.math.BigDecimal

data class DerivedVariables (
  val carbonLimits: CarbonLimits?,
  val excessEmissionPhase1: BigDecimal?,
  val excessEmissionPhase2: BigDecimal?,
  val penalties: Penalties?,
  val totalActualEmissions: BigDecimal?,
)

