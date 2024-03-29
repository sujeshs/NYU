package edu.nyu.sdg.penalties.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public final class LL84FeedData {

  private int id;
  private int order;
  private String propertyId;
  private String propertyName;
  private String parentPropertyId;
  private String parentPropertyName;
  private String cityBuilding;
  private String email;
  private String BBL10Digits;
  private String NYCBBLSelfReported;
  private String NYCBIN;
  private String address1SelfReported;
  private String address2SelfReported;
  private int postalCode;
  private String streetNumber;
  private String streetName;
  private String borough;
  private BigDecimal dofGrossFloorArea;
  private BigDecimal selfReportedGrossFloorArea;
  private String primaryPropertyTypeSelfSelected;
  private String listOfAllPropertyUseTypes;
  private String largestPropertyUseType;
  private BigDecimal largestPropertyUseTypeGrossFloorArea;
  private String secondLargestPropertyUseType;
  private BigDecimal secondLargestPropertyUseTypeGrossFloorArea;
  private String thirdLargestPropertyUseType;
  private BigDecimal thirdLargestPropertyUseTypeGrossFloorArea;
  private int yearBuilt;
  private int numberOfBuildings;
  private int occupancy;
  private String energyMeteredAreas;
  private String waterMeteredAreas;
  private int energyStarScore;
  private BigDecimal sourceEUI;
  private BigDecimal weatherNormalizedSiteEUI;
  private BigDecimal siteEUI;
  private BigDecimal weatherNormalizedSourceEUI;
  private BigDecimal weatherNormalizedElectricityIntensity;
  private BigDecimal weatherNormalizedNaturalGasIntensity;
  private BigDecimal fuelOil1Use;
  private BigDecimal fuelOil2Use;
  private BigDecimal fuelOil4Use;
  private BigDecimal fuelOil5_6Use;
  private BigDecimal diesel2Use;
  private BigDecimal keroseneUse;
  private BigDecimal propaneUse;
  private BigDecimal districtSteamUse;
  private BigDecimal districtHotWaterUse;
  private BigDecimal districtChilledWaterUse;
  private BigDecimal naturalGasUsekBTU;
  private BigDecimal naturalGasUseTherms;
  private BigDecimal weatherNormalizedSiteNaturalGasUseTherms;
  private BigDecimal electricityGridPurchasekBTU;
  private BigDecimal electricityGridPurchasekWh;
  private BigDecimal weatherNormalizedSiteElectricity;
  private BigDecimal annualMaximumDemandkW;
  private Date annualMaximumDemandDate;
  private String annualMaximumDemandMeterIDName;
  private BigDecimal totalGHGEmissions;
  private BigDecimal directGHGEmissions;
  private BigDecimal indirectGHGEmissions;
  private BigDecimal waterUseAllSources;
  private BigDecimal waterUseIntensityAllSources;
  private String waterRequired;
  private Date generationDate;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String communityBoard;
  private String councilDistrict;
  private String censusTract;
  private String nta;
  private List<AcrisEntry> acrisEntries;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(String propertyId) {
    this.propertyId = propertyId;
  }

  public String getPropertyName() {
    return propertyName;
  }

  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  public String getParentPropertyId() {
    return parentPropertyId;
  }

  public void setParentPropertyId(String parentPropertyId) {
    this.parentPropertyId = parentPropertyId;
  }

  public String getParentPropertyName() {
    return parentPropertyName;
  }

  public void setParentPropertyName(String parentPropertyName) {
    this.parentPropertyName = parentPropertyName;
  }

  public String getCityBuilding() {
    return cityBuilding;
  }

  public void setCityBuilding(String cityBuilding) {
    this.cityBuilding = cityBuilding;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBBL10Digits() {
    return BBL10Digits;
  }

  public void setBBL10Digits(String BBL10Digits) {
    this.BBL10Digits = BBL10Digits;
  }

  public String getNYCBBLSelfReported() {
    return NYCBBLSelfReported;
  }

  public void setNYCBBLSelfReported(String NYCBBLSelfReported) {
    this.NYCBBLSelfReported = NYCBBLSelfReported;
  }

  public String getNYCBIN() {
    return NYCBIN;
  }

  public void setNYCBIN(String NYCBIN) {
    this.NYCBIN = NYCBIN;
  }

  public String getAddress1SelfReported() {
    return address1SelfReported;
  }

  public void setAddress1SelfReported(String address1SelfReported) {
    this.address1SelfReported = address1SelfReported;
  }

  public String getAddress2SelfReported() {
    return address2SelfReported;
  }

  public void setAddress2SelfReported(String address2SelfReported) {
    this.address2SelfReported = address2SelfReported;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getBorough() {
    return borough;
  }

  public void setBorough(String borough) {
    this.borough = borough;
  }

  public BigDecimal getDofGrossFloorArea() {
    return dofGrossFloorArea;
  }

  public void setDofGrossFloorArea(BigDecimal dofGrossFloorArea) {
    this.dofGrossFloorArea = dofGrossFloorArea;
  }

  public BigDecimal getSelfReportedGrossFloorArea() {
    return selfReportedGrossFloorArea;
  }

  public void setSelfReportedGrossFloorArea(BigDecimal selfReportedGrossFloorArea) {
    this.selfReportedGrossFloorArea = selfReportedGrossFloorArea;
  }

  public String getPrimaryPropertyTypeSelfSelected() {
    return primaryPropertyTypeSelfSelected;
  }

  public void setPrimaryPropertyTypeSelfSelected(String primaryPropertyTypeSelfSelected) {
    this.primaryPropertyTypeSelfSelected = primaryPropertyTypeSelfSelected;
  }

  public String getListOfAllPropertyUseTypes() {
    return listOfAllPropertyUseTypes;
  }

  public void setListOfAllPropertyUseTypes(String listOfAllPropertyUseTypes) {
    this.listOfAllPropertyUseTypes = listOfAllPropertyUseTypes;
  }

  public String getLargestPropertyUseType() {
    return largestPropertyUseType;
  }

  public void setLargestPropertyUseType(String largestPropertyUseType) {
    this.largestPropertyUseType = largestPropertyUseType;
  }

  public BigDecimal getLargestPropertyUseTypeGrossFloorArea() {
    return largestPropertyUseTypeGrossFloorArea;
  }

  public void setLargestPropertyUseTypeGrossFloorArea(
      BigDecimal largestPropertyUseTypeGrossFloorArea) {
    this.largestPropertyUseTypeGrossFloorArea = largestPropertyUseTypeGrossFloorArea;
  }

  public String getSecondLargestPropertyUseType() {
    return secondLargestPropertyUseType;
  }

  public void setSecondLargestPropertyUseType(String secondLargestPropertyUseType) {
    this.secondLargestPropertyUseType = secondLargestPropertyUseType;
  }

  public BigDecimal getSecondLargestPropertyUseTypeGrossFloorArea() {
    return secondLargestPropertyUseTypeGrossFloorArea;
  }

  public void setSecondLargestPropertyUseTypeGrossFloorArea(
      BigDecimal secondLargestPropertyUseTypeGrossFloorArea) {
    this.secondLargestPropertyUseTypeGrossFloorArea = secondLargestPropertyUseTypeGrossFloorArea;
  }

  public String getThirdLargestPropertyUseType() {
    return thirdLargestPropertyUseType;
  }

  public void setThirdLargestPropertyUseType(String thirdLargestPropertyUseType) {
    this.thirdLargestPropertyUseType = thirdLargestPropertyUseType;
  }

  public BigDecimal getThirdLargestPropertyUseTypeGrossFloorArea() {
    return thirdLargestPropertyUseTypeGrossFloorArea;
  }

  public void setThirdLargestPropertyUseTypeGrossFloorArea(
      BigDecimal thirdLargestPropertyUseTypeGrossFloorArea) {
    this.thirdLargestPropertyUseTypeGrossFloorArea = thirdLargestPropertyUseTypeGrossFloorArea;
  }

  public int getYearBuilt() {
    return yearBuilt;
  }

  public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;
  }

  public int getNumberOfBuildings() {
    return numberOfBuildings;
  }

  public void setNumberOfBuildings(int numberOfBuildings) {
    this.numberOfBuildings = numberOfBuildings;
  }

  public int getOccupancy() {
    return occupancy;
  }

  public void setOccupancy(int occupancy) {
    this.occupancy = occupancy;
  }

  public String getEnergyMeteredAreas() {
    return energyMeteredAreas;
  }

  public void setEnergyMeteredAreas(String energyMeteredAreas) {
    this.energyMeteredAreas = energyMeteredAreas;
  }

  public String getWaterMeteredAreas() {
    return waterMeteredAreas;
  }

  public void setWaterMeteredAreas(String waterMeteredAreas) {
    this.waterMeteredAreas = waterMeteredAreas;
  }

  public int getEnergyStarScore() {
    return energyStarScore;
  }

  public void setEnergyStarScore(int energyStarScore) {
    this.energyStarScore = energyStarScore;
  }

  public BigDecimal getSourceEUI() {
    return sourceEUI;
  }

  public void setSourceEUI(BigDecimal sourceEUI) {
    this.sourceEUI = sourceEUI;
  }

  public BigDecimal getWeatherNormalizedSiteEUI() {
    return weatherNormalizedSiteEUI;
  }

  public void setWeatherNormalizedSiteEUI(BigDecimal weatherNormalizedSiteEUI) {
    this.weatherNormalizedSiteEUI = weatherNormalizedSiteEUI;
  }

  public BigDecimal getSiteEUI() {
    return siteEUI;
  }

  public void setSiteEUI(BigDecimal siteEUI) {
    this.siteEUI = siteEUI;
  }

  public BigDecimal getWeatherNormalizedSourceEUI() {
    return weatherNormalizedSourceEUI;
  }

  public void setWeatherNormalizedSourceEUI(BigDecimal weatherNormalizedSourceEUI) {
    this.weatherNormalizedSourceEUI = weatherNormalizedSourceEUI;
  }

  public BigDecimal getWeatherNormalizedElectricityIntensity() {
    return weatherNormalizedElectricityIntensity;
  }

  public void setWeatherNormalizedElectricityIntensity(
      BigDecimal weatherNormalizedElectricityIntensity) {
    this.weatherNormalizedElectricityIntensity = weatherNormalizedElectricityIntensity;
  }

  public BigDecimal getWeatherNormalizedNaturalGasIntensity() {
    return weatherNormalizedNaturalGasIntensity;
  }

  public void setWeatherNormalizedNaturalGasIntensity(
      BigDecimal weatherNormalizedNaturalGasIntensity) {
    this.weatherNormalizedNaturalGasIntensity = weatherNormalizedNaturalGasIntensity;
  }

  public BigDecimal getFuelOil1Use() {
    return fuelOil1Use;
  }

  public void setFuelOil1Use(BigDecimal fuelOil1Use) {
    this.fuelOil1Use = fuelOil1Use;
  }

  public BigDecimal getFuelOil2Use() {
    return fuelOil2Use;
  }

  public void setFuelOil2Use(BigDecimal fuelOil2Use) {
    this.fuelOil2Use = fuelOil2Use;
  }

  public BigDecimal getFuelOil4Use() {
    return fuelOil4Use;
  }

  public void setFuelOil4Use(BigDecimal fuelOil4Use) {
    this.fuelOil4Use = fuelOil4Use;
  }

  public BigDecimal getFuelOil5_6Use() {
    return fuelOil5_6Use;
  }

  public void setFuelOil5_6Use(BigDecimal fuelOil5_6Use) {
    this.fuelOil5_6Use = fuelOil5_6Use;
  }

  public BigDecimal getDiesel2Use() {
    return diesel2Use;
  }

  public void setDiesel2Use(BigDecimal diesel2Use) {
    this.diesel2Use = diesel2Use;
  }

  public BigDecimal getKeroseneUse() {
    return keroseneUse;
  }

  public void setKeroseneUse(BigDecimal keroseneUse) {
    this.keroseneUse = keroseneUse;
  }

  public BigDecimal getPropaneUse() {
    return propaneUse;
  }

  public void setPropaneUse(BigDecimal propaneUse) {
    this.propaneUse = propaneUse;
  }

  public BigDecimal getDistrictSteamUse() {
    return districtSteamUse;
  }

  public void setDistrictSteamUse(BigDecimal districtSteamUse) {
    this.districtSteamUse = districtSteamUse;
  }

  public BigDecimal getDistrictHotWaterUse() {
    return districtHotWaterUse;
  }

  public void setDistrictHotWaterUse(BigDecimal districtHotWaterUse) {
    this.districtHotWaterUse = districtHotWaterUse;
  }

  public BigDecimal getDistrictChilledWaterUse() {
    return districtChilledWaterUse;
  }

  public void setDistrictChilledWaterUse(BigDecimal districtChilledWaterUse) {
    this.districtChilledWaterUse = districtChilledWaterUse;
  }

  public BigDecimal getNaturalGasUsekBTU() {
    return naturalGasUsekBTU;
  }

  public void setNaturalGasUsekBTU(BigDecimal naturalGasUsekBTU) {
    this.naturalGasUsekBTU = naturalGasUsekBTU;
  }

  public BigDecimal getNaturalGasUseTherms() {
    return naturalGasUseTherms;
  }

  public void setNaturalGasUseTherms(BigDecimal naturalGasUseTherms) {
    this.naturalGasUseTherms = naturalGasUseTherms;
  }

  public BigDecimal getWeatherNormalizedSiteNaturalGasUseTherms() {
    return weatherNormalizedSiteNaturalGasUseTherms;
  }

  public void setWeatherNormalizedSiteNaturalGasUseTherms(
      BigDecimal weatherNormalizedSiteNaturalGasUseTherms) {
    this.weatherNormalizedSiteNaturalGasUseTherms = weatherNormalizedSiteNaturalGasUseTherms;
  }

  public BigDecimal getElectricityGridPurchasekBTU() {
    return electricityGridPurchasekBTU;
  }

  public void setElectricityGridPurchasekBTU(BigDecimal electricityGridPurchasekBTU) {
    this.electricityGridPurchasekBTU = electricityGridPurchasekBTU;
  }

  public BigDecimal getElectricityGridPurchasekWh() {
    return electricityGridPurchasekWh;
  }

  public void setElectricityGridPurchasekWh(BigDecimal electricityGridPurchasekWh) {
    this.electricityGridPurchasekWh = electricityGridPurchasekWh;
  }

  public BigDecimal getWeatherNormalizedSiteElectricity() {
    return weatherNormalizedSiteElectricity;
  }

  public void setWeatherNormalizedSiteElectricity(BigDecimal weatherNormalizedSiteElectricity) {
    this.weatherNormalizedSiteElectricity = weatherNormalizedSiteElectricity;
  }

  public BigDecimal getAnnualMaximumDemandkW() {
    return annualMaximumDemandkW;
  }

  public void setAnnualMaximumDemandkW(BigDecimal annualMaximumDemandkW) {
    this.annualMaximumDemandkW = annualMaximumDemandkW;
  }

  public Date getAnnualMaximumDemandDate() {
    return annualMaximumDemandDate;
  }

  public void setAnnualMaximumDemandDate(Date annualMaximumDemandDate) {
    this.annualMaximumDemandDate = annualMaximumDemandDate;
  }

  public String getAnnualMaximumDemandMeterIDName() {
    return annualMaximumDemandMeterIDName;
  }

  public void setAnnualMaximumDemandMeterIDName(String annualMaximumDemandMeterIDName) {
    this.annualMaximumDemandMeterIDName = annualMaximumDemandMeterIDName;
  }

  public BigDecimal getTotalGHGEmissions() {
    return totalGHGEmissions;
  }

  public void setTotalGHGEmissions(BigDecimal totalGHGEmissions) {
    this.totalGHGEmissions = totalGHGEmissions;
  }

  public BigDecimal getDirectGHGEmissions() {
    return directGHGEmissions;
  }

  public void setDirectGHGEmissions(BigDecimal directGHGEmissions) {
    this.directGHGEmissions = directGHGEmissions;
  }

  public BigDecimal getIndirectGHGEmissions() {
    return indirectGHGEmissions;
  }

  public void setIndirectGHGEmissions(BigDecimal indirectGHGEmissions) {
    this.indirectGHGEmissions = indirectGHGEmissions;
  }

  public BigDecimal getWaterUseAllSources() {
    return waterUseAllSources;
  }

  public void setWaterUseAllSources(BigDecimal waterUseAllSources) {
    this.waterUseAllSources = waterUseAllSources;
  }

  public BigDecimal getWaterUseIntensityAllSources() {
    return waterUseIntensityAllSources;
  }

  public void setWaterUseIntensityAllSources(BigDecimal waterUseIntensityAllSources) {
    this.waterUseIntensityAllSources = waterUseIntensityAllSources;
  }

  public String getWaterRequired() {
    return waterRequired;
  }

  public void setWaterRequired(String waterRequired) {
    this.waterRequired = waterRequired;
  }

  public Date getGenerationDate() {
    return generationDate;
  }

  public void setGenerationDate(Date generationDate) {
    this.generationDate = generationDate;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public String getCommunityBoard() {
    return communityBoard;
  }

  public void setCommunityBoard(String communityBoard) {
    this.communityBoard = communityBoard;
  }

  public String getCouncilDistrict() {
    return councilDistrict;
  }

  public void setCouncilDistrict(String councilDistrict) {
    this.councilDistrict = councilDistrict;
  }

  public String getCensusTract() {
    return censusTract;
  }

  public void setCensusTract(String censusTract) {
    this.censusTract = censusTract;
  }

  public String getNta() {
    return nta;
  }

  public void setNta(String nta) {
    this.nta = nta;
  }

  public List<AcrisEntry> getAcrisEntries() {
    return acrisEntries;
  }

  public void setAcrisEntries(List<AcrisEntry> acrisEntries) {
    this.acrisEntries = acrisEntries;
  }

  @Override
  public String toString() {
    return "LL84FeedData{"
        + "id="
        + id
        + ", order="
        + order
        + ", propertyId='"
        + propertyId
        + '\''
        + ", propertyName='"
        + propertyName
        + '\''
        + ", parentPropertyId='"
        + parentPropertyId
        + '\''
        + ", parentPropertyName='"
        + parentPropertyName
        + '\''
        + ", cityBuilding='"
        + cityBuilding
        + '\''
        + ", email='"
        + email
        + '\''
        + ", BBL10Digits='"
        + BBL10Digits
        + '\''
        + ", NYCBBLSelfReported='"
        + NYCBBLSelfReported
        + '\''
        + ", NYCBIN='"
        + NYCBIN
        + '\''
        + ", address1SelfReported='"
        + address1SelfReported
        + '\''
        + ", address2SelfReported='"
        + address2SelfReported
        + '\''
        + ", postalCode="
        + postalCode
        + ", streetNumber='"
        + streetNumber
        + '\''
        + ", streetName='"
        + streetName
        + '\''
        + ", borough='"
        + borough
        + '\''
        + ", dofGrossFloorArea="
        + dofGrossFloorArea
        + ", selfReportedGrossFloorArea="
        + selfReportedGrossFloorArea
        + ", primaryPropertyTypeSelfSelected='"
        + primaryPropertyTypeSelfSelected
        + '\''
        + ", listOfAllPropertyUseTypes='"
        + listOfAllPropertyUseTypes
        + '\''
        + ", largestPropertyUseType='"
        + largestPropertyUseType
        + '\''
        + ", largestPropertyUseTypeGrossFloorArea="
        + largestPropertyUseTypeGrossFloorArea
        + ", secondLargestPropertyUseType='"
        + secondLargestPropertyUseType
        + '\''
        + ", secondLargestPropertyUseTypeGrossFloorArea="
        + secondLargestPropertyUseTypeGrossFloorArea
        + ", thirdLargestPropertyUseType='"
        + thirdLargestPropertyUseType
        + '\''
        + ", thirdLargestPropertyUseTypeGrossFloorArea="
        + thirdLargestPropertyUseTypeGrossFloorArea
        + ", yearBuilt="
        + yearBuilt
        + ", numberOfBuildings="
        + numberOfBuildings
        + ", occupancy="
        + occupancy
        + ", energyMeteredAreas='"
        + energyMeteredAreas
        + '\''
        + ", waterMeteredAreas='"
        + waterMeteredAreas
        + '\''
        + ", energyStarScore="
        + energyStarScore
        + ", sourceEUI="
        + sourceEUI
        + ", weatherNormalizedSiteEUI="
        + weatherNormalizedSiteEUI
        + ", siteEUI="
        + siteEUI
        + ", weatherNormalizedSourceEUI="
        + weatherNormalizedSourceEUI
        + ", weatherNormalizedElectricityIntensity="
        + weatherNormalizedElectricityIntensity
        + ", weatherNormalizedNaturalGasIntensity="
        + weatherNormalizedNaturalGasIntensity
        + ", fuelOil1Use="
        + fuelOil1Use
        + ", fuelOil2Use="
        + fuelOil2Use
        + ", fuelOil4Use="
        + fuelOil4Use
        + ", fuelOil5_6Use="
        + fuelOil5_6Use
        + ", diesel2Use="
        + diesel2Use
        + ", keroseneUse="
        + keroseneUse
        + ", propaneUse="
        + propaneUse
        + ", districtSteamUse="
        + districtSteamUse
        + ", districtHotWaterUse="
        + districtHotWaterUse
        + ", districtChilledWaterUse="
        + districtChilledWaterUse
        + ", naturalGasUsekBTU="
        + naturalGasUsekBTU
        + ", naturalGasUseTherms="
        + naturalGasUseTherms
        + ", weatherNormalizedSiteNaturalGasUseTherms="
        + weatherNormalizedSiteNaturalGasUseTherms
        + ", electricityGridPurchasekBTU="
        + electricityGridPurchasekBTU
        + ", electricityGridPurchasekWh="
        + electricityGridPurchasekWh
        + ", weatherNormalizedSiteElectricity="
        + weatherNormalizedSiteElectricity
        + ", annualMaximumDemandkW="
        + annualMaximumDemandkW
        + ", annualMaximumDemandDate="
        + annualMaximumDemandDate
        + ", annualMaximumDemandMeterIDName='"
        + annualMaximumDemandMeterIDName
        + '\''
        + ", totalGHGEmissions="
        + totalGHGEmissions
        + ", directGHGEmissions="
        + directGHGEmissions
        + ", indirectGHGEmissions="
        + indirectGHGEmissions
        + ", waterUseAllSources="
        + waterUseAllSources
        + ", waterUseIntensityAllSources="
        + waterUseIntensityAllSources
        + ", waterRequired='"
        + waterRequired
        + '\''
        + ", generationDate="
        + generationDate
        + ", latitude="
        + latitude
        + ", longitude="
        + longitude
        + ", communityBoard='"
        + communityBoard
        + '\''
        + ", councilDistrict='"
        + councilDistrict
        + '\''
        + ", censusTract='"
        + censusTract
        + '\''
        + ", nta='"
        + nta
        + '\''
        + ", acrisEntries="
        + acrisEntries
        + '}';
  }
}
