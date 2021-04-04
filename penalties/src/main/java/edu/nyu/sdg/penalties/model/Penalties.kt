package edu.nyu.sdg.penalties.model

import java.math.BigDecimal

data class Penalties (
  /** Phase 1 penalties (2024-2029)  */
  val phase1Penalties: BigDecimal,

  /** Phase 2 penalties (2030-2034)  */
  val phase2Penalties: BigDecimal,
)

