package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public final class LookupData {

    private Map<String, Map<String, BigDecimal>> ll97CarbonLimit;
    private Map<String, String> energysrcGHCoeff;
    private Map<String, String> ll84ll97;

    public Map<String, Map<String, BigDecimal>> getLl97CarbonLimit() {
        return ll97CarbonLimit;
    }

    public void setLl97CarbonLimit(Map<String, Map<String, BigDecimal>> ll97CarbonLimit) {
        this.ll97CarbonLimit = ll97CarbonLimit;
    }

    public Map<String, String> getEnergysrcGHCoeff() {
        return energysrcGHCoeff;
    }

    public void setEnergysrcGHCoeff(Map<String, String> energysrcGHCoeff) {
        this.energysrcGHCoeff = energysrcGHCoeff;
    }

    public Map<String, String> getLl84ll97() {
        return ll84ll97;
    }

    public void setLl84ll97(Map<String, String> ll84ll97) {
        this.ll84ll97 = ll84ll97;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LookupData that = (LookupData) o;
        return Objects.equals(ll97CarbonLimit, that.ll97CarbonLimit) &&
                Objects.equals(energysrcGHCoeff, that.energysrcGHCoeff) &&
                Objects.equals(ll84ll97, that.ll84ll97);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ll97CarbonLimit, energysrcGHCoeff, ll84ll97);
    }

    @Override
    public String toString() {
        return "LookupData{" +
                "ll97CarbonLimit=" + ll97CarbonLimit +
                ", energysrcGHCoeff=" + energysrcGHCoeff +
                ", ll84ll97=" + ll84ll97 +
                '}';
    }
}
