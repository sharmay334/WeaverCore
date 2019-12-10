package com.stpl.pms.javabeans;

public class WordSentenceBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String wordSentence;
	private Integer wordSentenceCode;

	public WordSentenceBean() {
	}

	public WordSentenceBean(Integer wordSentenceCode2, String wordSentence2) {
		this.wordSentence = wordSentence2;
		this.wordSentenceCode = wordSentenceCode2;
	}

	public String getWordSentence() {
		return wordSentence;
	}

	public void setWordSentence(String wordSentence) {
		this.wordSentence = wordSentence;
	}

	public Integer getWordSentenceCode() {
		return wordSentenceCode;
	}

	public void setWordSentenceCode(Integer wordSentenceCode) {
		this.wordSentenceCode = wordSentenceCode;
	}

}
