package edu.nyu.sdg.penalties.model

import java.math.BigDecimal

data class CarbonLimits(
  val carbonLimitPhase1: BigDecimal?,
  val carbonLimitPhase2: BigDecimal?,
)
