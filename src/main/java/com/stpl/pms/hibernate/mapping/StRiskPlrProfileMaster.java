package com.stpl.pms.hibernate.mapping;

public class StRiskPlrProfileMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private Double regScoreAsNew;
	private Double regScoreAsOld;
	private Double depoScoreAsNew;
	private Double depoScoreAsOld;
	private Double withScoreAsNew;
	private Double withScoreAsOld;

	/** default constructor */
	public StRiskPlrProfileMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Double getRegScoreAsNew() {
		return this.regScoreAsNew;
	}

	public void setRegScoreAsNew(Double regScoreAsNew) {
		this.regScoreAsNew = regScoreAsNew;
	}

	public Double getRegScoreAsOld() {
		return this.regScoreAsOld;
	}

	public void setRegScoreAsOld(Double regScoreAsOld) {
		this.regScoreAsOld = regScoreAsOld;
	}

	public Double getDepoScoreAsNew() {
		return this.depoScoreAsNew;
	}

	public void setDepoScoreAsNew(Double depoScoreAsNew) {
		this.depoScoreAsNew = depoScoreAsNew;
	}

	public Double getDepoScoreAsOld() {
		return this.depoScoreAsOld;
	}

	public void setDepoScoreAsOld(Double depoScoreAsOld) {
		this.depoScoreAsOld = depoScoreAsOld;
	}

	public Double getWithScoreAsNew() {
		return this.withScoreAsNew;
	}

	public void setWithScoreAsNew(Double withScoreAsNew) {
		this.withScoreAsNew = withScoreAsNew;
	}

	public Double getWithScoreAsOld() {
		return this.withScoreAsOld;
	}

	public void setWithScoreAsOld(Double withScoreAsOld) {
		this.withScoreAsOld = withScoreAsOld;
	}

}