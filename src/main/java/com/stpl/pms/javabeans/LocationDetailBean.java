package com.stpl.pms.javabeans;

public class LocationDetailBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String countryName;
	private String region;
	private String regionName;
	private String city;
	private String postalCode;
	private float latitude;
	private float longitude;
	private double distance;
	private int metroCode;
	private int areaCode;
	private String timezone;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getMetroCode() {
		return metroCode;
	}
	public void setMetroCode(int metroCode) {
		this.metroCode = metroCode;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getAreaCode() {
		return areaCode;
	}
	@Override
	public String toString() {
		return "LocationDetailBean [countryCode=" + countryCode + ", countryName=" + countryName + ", region=" + region
				+ ", regionName=" + regionName + ", city=" + city + ", postalCode=" + postalCode + ", latitude="
				+ latitude + ", longitude=" + longitude + ", distance=" + distance + ", metroCode=" + metroCode
				+ ", areaCode=" + areaCode + ", timezone=" + timezone + "]";
	}

	
}
