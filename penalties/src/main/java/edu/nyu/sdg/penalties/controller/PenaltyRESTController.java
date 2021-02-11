package edu.nyu.sdg.penalties.controller;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.model.LL84Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PenaltyRESTController {

  private final FlowOrchestrator flowOrchestrator;

  public PenaltyRESTController(FlowOrchestrator flowOrchestrator) {
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");
  }

  @PostMapping("/penalty")
  public String getCarbonLimits(@RequestBody LL84Data ll84Data) {

    return flowOrchestrator.calculatePenalties(ll84Data).toString();
  }
}
