package com.stpl.pms.hibernate.mapping;


/**
 * StPmPlrReferenceMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrReferenceMapping implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long refMappingId;
	private Long playerId;
	private Short referenceId;
	private String referenceTxt1;
	private String referenceTxt2;
	private String referenceTxt3;
	
	// Constructors

	/** default constructor */
	public StPmPlrReferenceMapping() {
	}

	/** minimal constructor */
	public StPmPlrReferenceMapping(Short referenceId) {
		this.referenceId = referenceId;
	}

	/** full constructor */
	public StPmPlrReferenceMapping(Short referenceId,
			String referenceTxt1, String referenceTxt2, String referenceTxt3) {
		this.referenceId = referenceId;
		this.referenceTxt1 = referenceTxt1;
		this.referenceTxt2 = referenceTxt2;
		this.referenceTxt3 = referenceTxt3;
	}

	// Property accessors

	public Long getRefMappingId() {
		return this.refMappingId;
	}

	public void setRefMappingId(Long refMappingId) {
		this.refMappingId = refMappingId;
	}

	

	public Short getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Short referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceTxt1() {
		return this.referenceTxt1;
	}

	public void setReferenceTxt1(String referenceTxt1) {
		this.referenceTxt1 = referenceTxt1;
	}

	public String getReferenceTxt2() {
		return this.referenceTxt2;
	}

	public void setReferenceTxt2(String referenceTxt2) {
		this.referenceTxt2 = referenceTxt2;
	}

	public String getReferenceTxt3() {
		return this.referenceTxt3;
	}

	public void setReferenceTxt3(String referenceTxt3) {
		this.referenceTxt3 = referenceTxt3;
	}


	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Long getPlayerId() {
		return playerId;
	}

}