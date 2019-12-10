package com.stpl.pms.utility.location;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.log4j.Logger;

import com.maxmind.geoip2.GeoIp2Provider;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Subdivision;
import com.stpl.pms.javabeans.LocationDetailBean;

public abstract class AbstractMaxmindService implements MaxmindService {
	private static final Logger logger = Logger.getLogger(AbstractMaxmindService.class);
	@Override
	public LocationDetailBean getLocation(String ip) {
		LocationDetailBean locationDetailBean = new LocationDetailBean();
		CityResponse locationDetails=null;
		logger.info("Looking up IP in MaxMind DB\t\t...");
		Long startTime=System.currentTimeMillis();
		GeoIp2Provider provider;
		try {
			provider = getProvider();
			try {
				locationDetails = provider.city(InetAddress.getByName(ip));
			} catch (GeoIp2Exception e) {
				logger.warn(e.getMessage());
				locationDetailBean.setCountryCode("UNKNOWN_COUNTRY");
				locationDetailBean.setCountryName("UNKNOWN_COUNTRY");
				locationDetailBean.setCity("UNKNOWN_CITY");
				locationDetailBean.setRegion("UNKNOWN_REGION");
				locationDetailBean.setRegionName("UNKNOWN_STATE");
			}
			if (locationDetails == null) {
				locationDetailBean.setCountryCode("UNKNOWN_COUNTRY");
				locationDetailBean.setCountryName("UNKNOWN_COUNTRY");
				locationDetailBean.setCity("UNKNOWN_CITY");
				locationDetailBean.setRegion("UNKNOWN_REGION");
				locationDetailBean.setRegionName("UNKNOWN_STATE");
			} else {
				locationDetailBean.setCountryCode(locationDetails.getCountry().getIsoCode());
				locationDetailBean.setCountryName(locationDetails.getCountry().getName());
				locationDetailBean.setCity(locationDetails.getCity().getName());
				Subdivision subDivision=locationDetails.getMostSpecificSubdivision()==null?locationDetails.getLeastSpecificSubdivision():locationDetails.getMostSpecificSubdivision();
				locationDetailBean.setRegion(subDivision==null?null:subDivision.getIsoCode());
				locationDetailBean.setPostalCode(locationDetails.getPostal().getCode());
				locationDetailBean.setRegionName(subDivision==null?null:subDivision.getName());
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (Exception e){
			logger.info(e.getMessage());
		}
		
		logger.info("Took "+(System.currentTimeMillis()-startTime)+" millis to fetch IP location!");
		return locationDetailBean;
	}

	protected abstract GeoIp2Provider getProvider() throws IOException;
}
