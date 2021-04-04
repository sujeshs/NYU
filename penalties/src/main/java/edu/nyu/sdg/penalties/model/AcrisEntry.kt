package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Date;

public final class AcrisEntry {

  private String BBL10Digits;
  private String documentId;
  private String documentType;
  private BigDecimal documentAmount;
  private Date documentRecordedTimestamp;
  private String partyType;
  private String name;
  private String address1;
  private String zipCode;

  public String getBBL10Digits() {
    return BBL10Digits;
  }

  public void setBBL10Digits(String BBL10Digits) {
    this.BBL10Digits = BBL10Digits;
  }

  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public BigDecimal getDocumentAmount() {
    return documentAmount;
  }

  public void setDocumentAmount(BigDecimal documentAmount) {
    this.documentAmount = documentAmount;
  }

  public Date getDocumentRecordedTimestamp() {
    return documentRecordedTimestamp;
  }

  public void setDocumentRecordedTimestamp(Date documentRecordedTimestamp) {
    this.documentRecordedTimestamp = documentRecordedTimestamp;
  }

  public String getPartyType() {
    return partyType;
  }

  public void setPartyType(String partyType) {
    this.partyType = partyType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "AcrisEntries{"
        + "BBL10Digits='"
        + BBL10Digits
        + '\''
        + ", documentId='"
        + documentId
        + '\''
        + ", documentType='"
        + documentType
        + '\''
        + ", documentAmount="
        + documentAmount
        + ", documentRecordedTimestamp="
        + documentRecordedTimestamp
        + ", partyType='"
        + partyType
        + '\''
        + ", name='"
        + name
        + '\''
        + ", address1='"
        + address1
        + '\''
        + ", zipCode='"
        + zipCode
        + '\''
        + '}';
  }
}
