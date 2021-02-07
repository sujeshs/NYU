package edu.nyu.sdg.penalties.controller;

import edu.nyu.sdg.penalties.model.Penalties;

public final class FlowOrchestrator {

  /**
   * Caculates penalties for excess carbon emission
   *
   * <p>Step 1 : Calculate carbon limit according to occupancy group
   *
   * <p>Step 2 : Calculate total emissions using energy consumption & Greenhouse gas coefficient
   *
   * <p>Step 3 : Calculate penalty at the defined rate for emissions over the limit
   *
   * @return penalties for excess carbon emission
   */
  public Penalties calculatePenalties() {

    throw new RuntimeException("finish this impl");
  }
}
