package edu.nyu.sdg.penalties.controller;

import edu.nyu.sdg.penalties.model.CarbonLimits;
import edu.nyu.sdg.penalties.model.LL84Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarbonLimitController {

    private final CarbonLimitCalculator carbonLimitCalculator;

    public CarbonLimitController(CarbonLimitCalculator carbonLimitCalculator) {
        this.carbonLimitCalculator = carbonLimitCalculator;
    }

    @PostMapping("/carbonlimit")
    public CarbonLimits getCarbonLimits(@RequestBody LL84Data ll84Data) {

        return carbonLimitCalculator.calculateCarbonLimit(ll84Data);
    }

}
