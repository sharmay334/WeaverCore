package com.stpl.pms.hibernate.mapping;

import java.util.Date;

/**
 * StGenWordSentenceLanguageMapping entity. @author MyEclipse Persistence Tools
 */

public class StGenWordSentenceLanguageMapping implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer wordSentenceCode;
	private Integer reviewedByUserId;
	private Date reviewedDateTime;
	private String translatedString;
	private Integer translationLanguageId;
	private String translationChanged;
	private StGenWordSentenceMaster stGenWordSentenceMaster;
	// Constructors

	/** default constructor */
	public StGenWordSentenceLanguageMapping() {
	}

	/** minimal constructor */
	public StGenWordSentenceLanguageMapping(Integer wordSentenceCode,
			Integer translationLanguageId, String translationChanged) {
		this.wordSentenceCode = wordSentenceCode;
		this.translationLanguageId = translationLanguageId;
		this.translationChanged = translationChanged;
	}

	/** full constructor */
	public StGenWordSentenceLanguageMapping(Integer wordSentenceCode,
			Integer reviewedByUserId, Date reviewedDateTime,
			String translatedString, Integer translationLanguageId,
			String translationChanged) {
		this.wordSentenceCode = wordSentenceCode;
		this.reviewedByUserId = reviewedByUserId;
		this.reviewedDateTime = reviewedDateTime;
		this.translatedString = translatedString;
		this.translationLanguageId = translationLanguageId;
		this.translationChanged = translationChanged;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getWordSentenceCode() {
		return this.wordSentenceCode;
	}

	public void setWordSentenceCode(Integer wordSentenceCode) {
		this.wordSentenceCode = wordSentenceCode;
	}

	public Integer getReviewedByUserId() {
		return this.reviewedByUserId;
	}

	public void setReviewedByUserId(Integer reviewedByUserId) {
		this.reviewedByUserId = reviewedByUserId;
	}

	public Date getReviewedDateTime() {
		return this.reviewedDateTime;
	}

	public void setReviewedDateTime(Date reviewedDateTime) {
		this.reviewedDateTime = reviewedDateTime;
	}

	public String getTranslatedString() {
		return this.translatedString;
	}

	public void setTranslatedString(String translatedString) {
		this.translatedString = translatedString;
	}

	public Integer getTranslationLanguageId() {
		return this.translationLanguageId;
	}

	public void setTranslationLanguageId(Integer translationLanguageId) {
		this.translationLanguageId = translationLanguageId;
	}

	public String getTranslationChanged() {
		return this.translationChanged;
	}

	public void setTranslationChanged(String translationChanged) {
		this.translationChanged = translationChanged;
	}

	public void setStGenWordSentenceMaster(StGenWordSentenceMaster stGenWordSentenceMaster) {
		this.stGenWordSentenceMaster = stGenWordSentenceMaster;
	}

	public StGenWordSentenceMaster getStGenWordSentenceMaster() {
		return stGenWordSentenceMaster;
	}

}