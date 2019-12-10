package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * StCshDomainProviderMapping entity. @author MyEclipse Persistence Tools
 */

public class StCshDomainProviderMapping implements Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Short aliasId;
	private Integer providerId;
	private String merchantUserName;
	private String merchantPassword;
	private String merchantSecretKey;
	private String param;
	private Map<String ,String >  paramMap;
    private String altIdentifier;

    public String getAltIdentifier() {
        return altIdentifier;
    }

    public void setAltIdentifier(String altIdentifier) {
        this.altIdentifier = altIdentifier;
    }


    // Constructors

	/** default constructor */
	public StCshDomainProviderMapping() {
	}

	/** minimal constructor */
	public StCshDomainProviderMapping(Short domainId, Integer providerId) {
		this.domainId = domainId;
		this.providerId = providerId;
	}

	/** full constructor */
	public StCshDomainProviderMapping(Short domainId,Short aliasId, Integer providerId,
			String merchantUserName, String merchantPassword,
			String merchantSecretKey) {
		this.domainId = domainId;
		this.aliasId  = aliasId;
		this.providerId = providerId;
		this.merchantUserName = merchantUserName;
		this.merchantPassword = merchantPassword;
		this.merchantSecretKey = merchantSecretKey;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getMerchantUserName() {
		return this.merchantUserName;
	}

	public void setMerchantUserName(String merchantUserName) {
		this.merchantUserName = merchantUserName;
	}

	public String getMerchantPassword() {
		return this.merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public String getMerchantSecretKey() {
		return this.merchantSecretKey;
	}

	public void setMerchantSecretKey(String merchantSecretKey) {
		this.merchantSecretKey = merchantSecretKey;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;	

		try{			
			this.paramMap = new HashMap<>();
			if(param !=null){
				
				paramMap = new ObjectMapper().readValue(param, Map.class);
//				for(String keyValue: param.split(",")){
//					String[] frags = keyValue.split(":");
//					paramMap.put(frags[0], frags[1]);
//				}
			}
		}catch(Exception e){
			Exception ex = new Exception("WARNING: this cannot cause gracefull crash", e);
			ex.printStackTrace();
		}
	}

	public Map<String ,String> paramMap(){
		return this.paramMap;
	}
}