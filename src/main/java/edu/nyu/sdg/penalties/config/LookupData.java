package edu.nyu.sdg.penalties.config;

import java.util.Map;
import java.util.Objects;

public final class LookupData {

    private Map<String, Map<String, String>> ll97CarbonLimit;
    private Map<String, String> energysrcGHCoeff;
    private Map<String, String> ll84ll97;

    public Map<String, String> getLl84ll97() {
        return ll84ll97;
    }

    public void setLl84ll97(Map<String, String> ll84ll97) {
        this.ll84ll97 = ll84ll97;
    }

    public Map<String, Map<String, String>> getLl97CarbonLimit() {
        return ll97CarbonLimit;
    }

    public void setLl97CarbonLimit(Map<String, Map<String, String>> ll97CarbonLimit) {
        this.ll97CarbonLimit = ll97CarbonLimit;
    }

    public Map<String, String> getEnergysrcGHCoeff() {
        return energysrcGHCoeff;
    }

    public void setEnergysrcGHCoeff(Map<String, String> energysrcGHCoeff) {
        this.energysrcGHCoeff = energysrcGHCoeff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LookupData that = (LookupData) o;
        return Objects.equals(ll84ll97, that.ll84ll97) && Objects.equals(ll97CarbonLimit, that.ll97CarbonLimit) && Objects.equals(energysrcGHCoeff, that.energysrcGHCoeff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ll84ll97, ll97CarbonLimit, energysrcGHCoeff);
    }

    @Override
    public String toString() {
        return "LookupData{" +
                "ll84ll97=" + ll84ll97 +
                ", ll97CarbonLimit=" + ll97CarbonLimit +
                ", energysrcGHCoeff=" + energysrcGHCoeff +
                '}';
    }
}
