package com.stpl.pms.utility.location;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.maxmind.geoip2.GeoIp2Provider;
import com.maxmind.geoip2.WebServiceClient;

public class APIMaxmindService extends AbstractMaxmindService {
	private static final Logger logger = Logger.getLogger(APIMaxmindService.class);
	private static final WebServiceClient provider = buildClient();

	private static WebServiceClient buildClient() {
		WebServiceClient provider = null;
		try {
			provider  = new WebServiceClient.Builder(128851, "ZlhU567GOkfU").build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return provider;
	}

	@Override
	protected GeoIp2Provider getProvider() throws IOException {
		logger.info("Accessing Maxmind API provider");
		return provider;
	}
}
