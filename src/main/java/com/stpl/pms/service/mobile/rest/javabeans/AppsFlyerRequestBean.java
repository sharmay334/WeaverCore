package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppsFlyerRequestBean extends CommonRequestBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private Long androidActivityId;
	private String app_id;
	private String platform;
	private String click_time;
	private String install_time;
	private String agency;
	private String media_source;
	private String campaign;
	private String fb_campaign_name;
	private String fb_campaign_id;
	private String fb_adset_name;
	private String fb_adset_id;
	private String fb_adgroup_name;
	private String fb_adgroup_id;
	private String af_siteid;
	private String cost_per_install;
	private String country_code;
	private String city;
	private String ip;
	private String wifi;
	private String language;
	private String appsflyer_device_id;
	private String customer_user_id;
	private String advertising_id;
	private String android_id;
	private String imei;
	private String mac;
	private String device_brand;
	private String device_model;
	private String os_version;
	private String sdk_version;
	private String app_version;
	private String event_type;
	private String event_name;
	private String event_value;
	//private AppsFlyerEventValueBean event_value;
	//private String event_val;
	private String currency;
	private String event_time;
	private String af_sub1;
	private String af_sub2;
	private String af_sub3;
	private String af_sub4;
	private String af_sub5;
	private String click_url;
	private String attribution_type;
	private String idfa;
	private String device_name;
	private String device_type;
	private String operator;
	private String is_retargeting;
	private String re_targeting_conversion_type;
	private String carrier;
	
	public Long getAndroidActivityId() {
		return androidActivityId;
	}
	public void setAndroidActivityId(Long androidActivityId) {
		this.androidActivityId = androidActivityId;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getClick_time() {
		return click_time;
	}
	public void setClick_time(String click_time) {
		this.click_time = click_time;
	}
	public String getInstall_time() {
		return install_time;
	}
	public void setInstall_time(String install_time) {
		this.install_time = install_time;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getMedia_source() {
		return media_source;
	}
	public void setMedia_source(String media_source) {
		this.media_source = media_source;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public String getFb_campaign_name() {
		return fb_campaign_name;
	}
	public void setFb_campaign_name(String fb_campaign_name) {
		this.fb_campaign_name = fb_campaign_name;
	}
	public String getFb_campaign_id() {
		return fb_campaign_id;
	}
	public void setFb_campaign_id(String fb_campaign_id) {
		this.fb_campaign_id = fb_campaign_id;
	}
	public String getFb_adset_name() {
		return fb_adset_name;
	}
	public void setFb_adset_name(String fb_adset_name) {
		this.fb_adset_name = fb_adset_name;
	}
	public String getFb_adset_id() {
		return fb_adset_id;
	}
	public void setFb_adset_id(String fb_adset_id) {
		this.fb_adset_id = fb_adset_id;
	}
	public String getFb_adgroup_name() {
		return fb_adgroup_name;
	}
	public void setFb_adgroup_name(String fb_adgroup_name) {
		this.fb_adgroup_name = fb_adgroup_name;
	}
	public String getFb_adgroup_id() {
		return fb_adgroup_id;
	}
	public void setFb_adgroup_id(String fb_adgroup_id) {
		this.fb_adgroup_id = fb_adgroup_id;
	}
	public String getAf_siteid() {
		return af_siteid;
	}
	public void setAf_siteid(String af_siteid) {
		this.af_siteid = af_siteid;
	}
	public String getCost_per_install() {
		return cost_per_install;
	}
	public void setCost_per_install(String cost_per_install) {
		this.cost_per_install = cost_per_install;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAppsflyer_device_id() {
		return appsflyer_device_id;
	}
	public void setAppsflyer_device_id(String appsflyer_device_id) {
		this.appsflyer_device_id = appsflyer_device_id;
	}
	public String getCustomer_user_id() {
		return customer_user_id;
	}
	public void setCustomer_user_id(String customer_user_id) {
		this.customer_user_id = customer_user_id;
	}
	public String getAdvertising_id() {
		return advertising_id;
	}
	public void setAdvertising_id(String advertising_id) {
		this.advertising_id = advertising_id;
	}
	public String getAndroid_id() {
		return android_id;
	}
	public void setAndroid_id(String android_id) {
		this.android_id = android_id;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getDevice_brand() {
		return device_brand;
	}
	public void setDevice_brand(String device_brand) {
		this.device_brand = device_brand;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}
	public String getOs_version() {
		return os_version;
	}
	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}
	public String getSdk_version() {
		return sdk_version;
	}
	public void setSdk_version(String sdk_version) {
		this.sdk_version = sdk_version;
	}
	public String getApp_version() {
		return app_version;
	}
	public void setApp_version(String app_version) {
		this.app_version = app_version;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	
	
	/*public String getEvent_val() {
		return event_val;
	}
	public void setEvent_val(String event_val) {
		this.event_val = event_val;
	}
	*/
	public String getEvent_value() {
		return event_value;
	}
	public void setEvent_value(String event_value) {
		this.event_value = event_value;
	}
	/*public AppsFlyerEventValueBean getEvent_value() {
		return event_value;
	}
	public void setEvent_value(AppsFlyerEventValueBean event_value) {
		this.event_value = event_value;		
	}*/
	/*public List<AppsFlyerEventValueBean> getEvent_value() {
		return event_value;
	}
	public void setEvent_value(List<AppsFlyerEventValueBean> event_value) {
		JSONObject obj = new JSONObject(event_value);
		try {
			JSONArray array = obj.getJSONArray("event_value");
			for(int i = 0 ; i < array.length() ; i++){
			   event_val = array.getJSONObject(i).getString("username")+","+array.getJSONObject(i).getString("af_revenue");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//event_val = event_value.toString();
		this.event_value = event_value;
	}*/
	/*public String getEvent_value() {
		return event_value;
	}
	public void setEvent_value(String event_value) {
		this.event_value = event_value;
		Type type = new TypeToken<AppsFlyerEventValueBean>() {}.getType();
		this.event_value = new Gson().fromJson(event_value, type);
		//this.event_value = event_value;
	}*/
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public String getAf_sub1() {
		return af_sub1;
	}
	public void setAf_sub1(String af_sub1) {
		this.af_sub1 = af_sub1;
	}
	public String getAf_sub2() {
		return af_sub2;
	}
	public void setAf_sub2(String af_sub2) {
		this.af_sub2 = af_sub2;
	}
	public String getAf_sub3() {
		return af_sub3;
	}
	public void setAf_sub3(String af_sub3) {
		this.af_sub3 = af_sub3;
	}
	public String getAf_sub4() {
		return af_sub4;
	}
	public void setAf_sub4(String af_sub4) {
		this.af_sub4 = af_sub4;
	}
	public String getAf_sub5() {
		return af_sub5;
	}
	public void setAf_sub5(String af_sub5) {
		this.af_sub5 = af_sub5;
	}
	public String getClick_url() {
		return click_url;
	}
	public void setClick_url(String click_url) {
		this.click_url = click_url;
	}
	public String getAttribution_type() {
		return attribution_type;
	}
	public void setAttribution_type(String attribution_type) {
		this.attribution_type = attribution_type;
	}
	public String getIdfa() {
		return idfa;
	}
	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getIs_retargeting() {
		return is_retargeting;
	}
	public void setIs_retargeting(String is_retargeting) {
		this.is_retargeting = is_retargeting;
	}
	public String getRe_targeting_conversion_type() {
		return re_targeting_conversion_type;
	}
	public void setRe_targeting_conversion_type(String re_targeting_conversion_type) {
		this.re_targeting_conversion_type = re_targeting_conversion_type;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public AppsFlyerRequestBean()
	{
		
	}
	public AppsFlyerRequestBean(String app_id,
			String platform, String click_time, String install_time,
			String agency, String media_source, String campaign,
			String fb_campaign_name, String fb_campaign_id,
			String fb_adset_name, String fb_adset_id, String fb_adgroup_name,
			String fb_adgroup_id, String af_siteid, String cost_per_install,
			String country_code, String city, String ip, String wifi,
			String language, String appsflyer_device_id,
			String customer_user_id, String advertising_id, String android_id,
			String imei, String mac, String device_brand, String device_model,
			String os_version, String sdk_version, String app_version,
			String event_type, String event_name, String event_value,
			String currency, String event_time,
			String af_sub1, String af_sub2, String af_sub3, String af_sub4,
			String af_sub5, String click_url, String attribution_type,
			String idfa, String device_name, String device_type,
			String operator, String is_retargeting,
			String re_targeting_conversion_type, String carrier) {
		this.app_id = app_id;
		this.platform = platform;
		this.click_time = click_time;
		this.install_time = install_time;
		this.agency = agency;
		this.media_source = media_source;
		this.campaign = campaign;
		this.fb_campaign_name = fb_campaign_name;
		this.fb_campaign_id = fb_campaign_id;
		this.fb_adset_name = fb_adset_name;
		this.fb_adset_id = fb_adset_id;
		this.fb_adgroup_name = fb_adgroup_name;
		this.fb_adgroup_id = fb_adgroup_id;
		this.af_siteid = af_siteid;
		this.cost_per_install = cost_per_install;
		this.country_code = country_code;
		this.city = city;
		this.ip = ip;
		this.wifi = wifi;
		this.language = language;
		this.appsflyer_device_id = appsflyer_device_id;
		this.customer_user_id = customer_user_id;
		this.advertising_id = advertising_id;
		this.android_id = android_id;
		this.imei = imei;
		this.mac = mac;
		this.device_brand = device_brand;
		this.device_model = device_model;
		this.os_version = os_version;
		this.sdk_version = sdk_version;
		this.app_version = app_version;
		this.event_type = event_type;
		this.event_name = event_name;
		this.event_value = event_value;
		this.currency = currency;
		this.event_time = event_time;
		this.af_sub1 = af_sub1;
		this.af_sub2 = af_sub2;
		this.af_sub3 = af_sub3;
		this.af_sub4 = af_sub4;
		this.af_sub5 = af_sub5;
		this.click_url = click_url;
		this.attribution_type = attribution_type;
		this.idfa = idfa;
		this.device_name = device_name;
		this.device_type = device_type;
		this.operator = operator;
		this.is_retargeting = is_retargeting;
		this.re_targeting_conversion_type = re_targeting_conversion_type;
		this.carrier = carrier;
	}
	
	
	

}
