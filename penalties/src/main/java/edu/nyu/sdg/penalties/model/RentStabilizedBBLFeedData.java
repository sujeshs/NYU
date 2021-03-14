package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;

public final class RentStabilizedBBLFeedData {

  private String BBL;
  private String mpVersion;
  private int mpResidentialUnits;
  private int stabilizedUnits2018;
  private int stabilizedUnits2019;
  private BigDecimal stabilizedUnitPercentage;

  public String getBBL() {
    return BBL;
  }

  public void setBBL(String BBL) {
    this.BBL = BBL;
  }

  public String getMpVersion() {
    return mpVersion;
  }

  public void setMpVersion(String mpVersion) {
    this.mpVersion = mpVersion;
  }

  public int getMpResidentialUnits() {
    return mpResidentialUnits;
  }

  public void setMpResidentialUnits(int mpResidentialUnits) {
    this.mpResidentialUnits = mpResidentialUnits;
  }

  public int getStabilizedUnits2018() {
    return stabilizedUnits2018;
  }

  public void setStabilizedUnits2018(int stabilizedUnits2018) {
    this.stabilizedUnits2018 = stabilizedUnits2018;
  }

  public int getStabilizedUnits2019() {
    return stabilizedUnits2019;
  }

  public void setStabilizedUnits2019(int stabilizedUnits2019) {
    this.stabilizedUnits2019 = stabilizedUnits2019;
  }

  public BigDecimal getStabilizedUnitPercentage() {
    return stabilizedUnitPercentage;
  }

  public void setStabilizedUnitPercentage(BigDecimal stabilizedUnitPercentage) {
    this.stabilizedUnitPercentage = stabilizedUnitPercentage;
  }

  @Override
  public String toString() {
    return "RentStabilizedBBLFeedData{"
        + "BBL='"
        + BBL
        + '\''
        + ", mpVersion='"
        + mpVersion
        + '\''
        + ", mpResidentialUnits="
        + mpResidentialUnits
        + ", stabilizedUnits2018="
        + stabilizedUnits2018
        + ", stabilizedUnits2019="
        + stabilizedUnits2019
        + ", stabilizedUnitPercentage="
        + stabilizedUnitPercentage
        + '}';
  }
}
