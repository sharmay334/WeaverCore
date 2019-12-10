package com.stpl.pms.hibernate.mapping;

import java.util.Date;

/**
 * StGenWordSentenceMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenWordSentenceMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long wordSentenceId;
	private String wordSentence;
	private Integer wordSentenceLanguageId;
	private String enteredByUserType;
	private Long enteredByUserId;
	private Date enteredDateTime;
	private Integer wordSentenceCode;
	private String baseLangReviewed;
	private Integer baseLangReviewedUserId;
	private Date baseLangReviewdDateTime;
	private String baseLangTranslatedWord;
	private String baseLangWordChanged;

	// Constructors

	/** default constructor */
	public StGenWordSentenceMaster() {
	}

	/** full constructor */
	public StGenWordSentenceMaster(String wordSentence,
			Integer wordSentenceLanguageId, String enteredByUserType,
			Long enteredByUserId, Date enteredDateTime,
			Integer wordSentenceCode, String baseLangReviewed,
			Integer baseLangReviewedUserId, Date baseLangReviewdDateTime,
			String baseLangTranslatedWord, String baseLangWordChanged) {
		this.wordSentence = wordSentence;
		this.wordSentenceLanguageId = wordSentenceLanguageId;
		this.enteredByUserType = enteredByUserType;
		this.enteredByUserId = enteredByUserId;
		this.enteredDateTime = enteredDateTime;
		this.wordSentenceCode = wordSentenceCode;
		this.baseLangReviewed = baseLangReviewed;
		this.baseLangReviewedUserId = baseLangReviewedUserId;
		this.baseLangReviewdDateTime = baseLangReviewdDateTime;
		this.baseLangTranslatedWord = baseLangTranslatedWord;
		this.baseLangWordChanged = baseLangWordChanged;
	}

	// Property accessors

	public Long getWordSentenceId() {
		return this.wordSentenceId;
	}

	public void setWordSentenceId(Long wordSentenceId) {
		this.wordSentenceId = wordSentenceId;
	}

	public String getWordSentence() {
		return this.wordSentence;
	}

	public void setWordSentence(String wordSentence) {
		this.wordSentence = wordSentence;
	}

	public Integer getWordSentenceLanguageId() {
		return this.wordSentenceLanguageId;
	}

	public void setWordSentenceLanguageId(Integer wordSentenceLanguageId) {
		this.wordSentenceLanguageId = wordSentenceLanguageId;
	}

	public String getEnteredByUserType() {
		return this.enteredByUserType;
	}

	public void setEnteredByUserType(String enteredByUserType) {
		this.enteredByUserType = enteredByUserType;
	}

	public Long getEnteredByUserId() {
		return this.enteredByUserId;
	}

	public void setEnteredByUserId(Long enteredByUserId) {
		this.enteredByUserId = enteredByUserId;
	}

	public Date getEnteredDateTime() {
		return this.enteredDateTime;
	}

	public void setEnteredDateTime(Date enteredDateTime) {
		this.enteredDateTime = enteredDateTime;
	}

	public Integer getWordSentenceCode() {
		return this.wordSentenceCode;
	}

	public void setWordSentenceCode(Integer wordSentenceCode) {
		this.wordSentenceCode = wordSentenceCode;
	}

	public String getBaseLangReviewed() {
		return this.baseLangReviewed;
	}

	public void setBaseLangReviewed(String baseLangReviewed) {
		this.baseLangReviewed = baseLangReviewed;
	}

	public Integer getBaseLangReviewedUserId() {
		return this.baseLangReviewedUserId;
	}

	public void setBaseLangReviewedUserId(Integer baseLangReviewedUserId) {
		this.baseLangReviewedUserId = baseLangReviewedUserId;
	}

	public Date getBaseLangReviewdDateTime() {
		return this.baseLangReviewdDateTime;
	}

	public void setBaseLangReviewdDateTime(Date baseLangReviewdDateTime) {
		this.baseLangReviewdDateTime = baseLangReviewdDateTime;
	}

	public String getBaseLangTranslatedWord() {
		return this.baseLangTranslatedWord;
	}

	public void setBaseLangTranslatedWord(String baseLangTranslatedWord) {
		this.baseLangTranslatedWord = baseLangTranslatedWord;
	}

	public String getBaseLangWordChanged() {
		return this.baseLangWordChanged;
	}

	public void setBaseLangWordChanged(String baseLangWordChanged) {
		this.baseLangWordChanged = baseLangWordChanged;
	}

}