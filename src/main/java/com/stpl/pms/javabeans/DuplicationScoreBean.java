package com.stpl.pms.javabeans;

public class DuplicationScoreBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Double regScoreAsNew;
	private Double regScoreAsOld;
	private Double depoScoreAsNew;
	private Double depoScoreAsOld;
	private Double withScoreAsNew;
	private Double withScoreAsOld;

	
	public Double getRegScoreAsNew() {
		return regScoreAsNew;
	}
	public Double getRegScoreAsOld() {
		return regScoreAsOld;
	}
	public Double getDepoScoreAsNew() {
		return depoScoreAsNew;
	}
	public Double getDepoScoreAsOld() {
		return depoScoreAsOld;
	}
	public Double getWithScoreAsNew() {
		return withScoreAsNew;
	}
	public Double getWithScoreAsOld() {
		return withScoreAsOld;
	}
	public void setRegScoreAsNew(Double regScoreAsNew) {
		this.regScoreAsNew = regScoreAsNew;
	}
	public void setRegScoreAsOld(Double regScoreAsOld) {
		this.regScoreAsOld = regScoreAsOld;
	}
	public void setDepoScoreAsNew(Double depoScoreAsNew) {
		this.depoScoreAsNew = depoScoreAsNew;
	}
	public void setDepoScoreAsOld(Double depoScoreAsOld) {
		this.depoScoreAsOld = depoScoreAsOld;
	}
	public void setWithScoreAsNew(Double withScoreAsNew) {
		this.withScoreAsNew = withScoreAsNew;
	}
	public void setWithScoreAsOld(Double withScoreAsOld) {
		this.withScoreAsOld = withScoreAsOld;
	}

	@Override
	public String toString() {
		return "DuplicationScoreBean [regScoreAsNew=" + regScoreAsNew
				+ ", regScoreAsOld=" + regScoreAsOld + "]";
	}
}
