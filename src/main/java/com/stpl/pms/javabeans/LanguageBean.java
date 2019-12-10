package com.stpl.pms.javabeans;

public class LanguageBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int languageId;
	private String languageName;
	private String languageCode;
	private String languageBaseCode;
	private String checked;

	public LanguageBean() {
	}

	public LanguageBean(int languageId, String languageName,
			String languageCode, String languageBaseCode) {
		this.languageId = languageId;
		this.languageName = languageName;
		this.languageCode = languageCode;
		this.languageBaseCode = languageBaseCode;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageBaseCode(String languageBaseCode) {
		this.languageBaseCode = languageBaseCode;
	}

	public String getLanguageBaseCode() {
		return languageBaseCode;
	}

}
