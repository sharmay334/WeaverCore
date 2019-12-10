package com.stpl.pms.utility.location;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.GeoIp2Provider;
import com.stpl.pms.utility.Utility;

public class DBMaxmindService extends AbstractMaxmindService {
	private static final Logger logger = Logger.getLogger(DBMaxmindService.class);
	private static final DatabaseReader provider = buildClient();

	private static DatabaseReader buildClient() {
		DatabaseReader provider = null;
		try {
			URL dbUrl = Thread.currentThread().getContextClassLoader().getResource("GeoLite2-City.mmdb");
			String path=dbUrl.toString().contains("vfs:")?Utility.vfsToRealPath(dbUrl):dbUrl.getPath();
			provider = new DatabaseReader.Builder(new File(path)).build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return provider;
	}

	@Override
	protected GeoIp2Provider getProvider() throws IOException {
		logger.info("Accessing Maxmind Database provider");
		return provider;
	}

}
