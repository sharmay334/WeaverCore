package com.stpl.pms.utility.location;

import com.stpl.pms.javabeans.LocationDetailBean;

public interface MaxmindService {
	LocationDetailBean getLocation(String ip);
}
