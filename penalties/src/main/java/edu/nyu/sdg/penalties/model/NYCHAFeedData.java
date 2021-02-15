package edu.nyu.sdg.penalties.model;

public final class NYCHAFeedData {

  private String BBL;
  private String development;

  public String getBBL() {
    return BBL;
  }

  public void setBBL(String BBL) {
    this.BBL = BBL;
  }

  public String getDevelopment() {
    return development;
  }

  public void setDevelopment(String development) {
    this.development = development;
  }

  @Override
  public String toString() {
    return "NYCHAFeedData{" + "BBL='" + BBL + '\'' + ", development='" + development + '\'' + '}';
  }
}
