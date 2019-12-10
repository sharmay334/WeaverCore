package com.stpl.pms.javabeans;

import java.io.File;

public class PlayerDocumentMasterBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long docId;
	private Long playerId;
	private String ageDocUniqueNo;
	private String ageDocType;
	private String ageDocPath;
	private String addDocUniqueNo;
	private String addDocType;
	private String addDocPath;
	private String taxIdDocUniqueNo;
	private String taxIdDocType;
	private String taxIdDocPath;
	private File ageImage;
	private String ageImageFileName;
	private String ageImageContentType;
	private File addImage;
	private File taxIdImage;
	private String addImageFileName;
	private String addImageContentType;
	private String taxIdImageFileName;
	private String taxIdImageContentType;
	private String ageDocVerified;
	private String addDocVerified;
	private String taxIdDocVerified;
	
	private File ageImageBackSide;
	private String ageImageBackSideFileName;
	private String ageImageBackSideContentType;
	
	private File addImageBackSide;
	private String addImageBackSideFileName;
	private String addImageBackSideContentType;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getAgeDocUniqueNo() {
		return ageDocUniqueNo;
	}

	public void setAgeDocUniqueNo(String ageDocUniqueNo) {
		this.ageDocUniqueNo = ageDocUniqueNo;
	}

	public String getAgeDocType() {
		return ageDocType;
	}

	public void setAgeDocType(String ageDocType) {
		this.ageDocType = ageDocType;
	}

	public String getAgeDocPath() {
		return ageDocPath;
	}

	public void setAgeDocPath(String ageDocPath) {
		this.ageDocPath = ageDocPath;
	}

	public String getAddDocUniqueNo() {
		return addDocUniqueNo;
	}

	public void setAddDocUniqueNo(String addDocUniqueNo) {
		this.addDocUniqueNo = addDocUniqueNo;
	}

	public String getAddDocType() {
		return addDocType;
	}

	public void setAddDocType(String addDocType) {
		this.addDocType = addDocType;
	}

	public String getAddDocPath() {
		return addDocPath;
	}

	public void setAddDocPath(String addDocPath) {
		this.addDocPath = addDocPath;
	}

	public String getTaxIdDocUniqueNo() {
		return taxIdDocUniqueNo;
	}

	public void setTaxIdDocUniqueNo(String taxIdDocUniqueNo) {
		this.taxIdDocUniqueNo = taxIdDocUniqueNo;
	}

	public String getTaxIdDocType() {
		return taxIdDocType;
	}

	public void setTaxIdDocType(String taxIdDocType) {
		this.taxIdDocType = taxIdDocType;
	}

	public String getTaxIdDocPath() {
		return taxIdDocPath;
	}

	public void setTaxIdDocPath(String taxIdDocPath) {
		this.taxIdDocPath = taxIdDocPath;
	}

	public File getAgeImage() {
		return ageImage;
	}

	public void setAgeImage(File ageImage) {
		this.ageImage = ageImage;
	}

	public String getAgeImageFileName() {
		return ageImageFileName;
	}

	public void setAgeImageFileName(String ageImageFileName) {
		this.ageImageFileName = ageImageFileName;
	}

	public String getAgeImageContentType() {
		return ageImageContentType;
	}

	public void setAgeImageContentType(String ageImageContentType) {
		this.ageImageContentType = ageImageContentType;
	}

	public File getAddImage() {
		return addImage;
	}

	public void setAddImage(File addImage) {
		this.addImage = addImage;
	}

	public File getTaxIdImage() {
		return taxIdImage;
	}

	public void setTaxIdImage(File taxIdImage) {
		this.taxIdImage = taxIdImage;
	}

	public String getAddImageFileName() {
		return addImageFileName;
	}

	public void setAddImageFileName(String addImageFileName) {
		this.addImageFileName = addImageFileName;
	}

	public String getAddImageContentType() {
		return addImageContentType;
	}

	public void setAddImageContentType(String addImageContentType) {
		this.addImageContentType = addImageContentType;
	}

	public String getTaxIdImageFileName() {
		return taxIdImageFileName;
	}

	public void setTaxIdImageFileName(String taxIdImageFileName) {
		this.taxIdImageFileName = taxIdImageFileName;
	}

	public String getTaxIdImageContentType() {
		return taxIdImageContentType;
	}

	public void setTaxIdImageContentType(String taxIdImageContentType) {
		this.taxIdImageContentType = taxIdImageContentType;
	}

	public String getAgeDocVerified() {
		return ageDocVerified;
	}

	public void setAgeDocVerified(String ageDocVerified) {
		this.ageDocVerified = ageDocVerified;
	}

	public String getAddDocVerified() {
		return addDocVerified;
	}

	public void setAddDocVerified(String addDocVerified) {
		this.addDocVerified = addDocVerified;
	}

	public String getTaxIdDocVerified() {
		return taxIdDocVerified;
	}

	public void setTaxIdDocVerified(String taxIdDocVerified) {
		this.taxIdDocVerified = taxIdDocVerified;
	}
	
	public File getAgeImageBackSide() {
		return ageImageBackSide;
	}

	public void setAgeImageBackSide(File ageImageBackSide) {
		this.ageImageBackSide = ageImageBackSide;
	}

	public String getAgeImageBackSideFileName() {
		return ageImageBackSideFileName;
	}

	public void setAgeImageBackSideFileName(String ageImageBackSideFileName) {
		this.ageImageBackSideFileName = ageImageBackSideFileName;
	}

	public String getAgeImageBackSideContentType() {
		return ageImageBackSideContentType;
	}

	public void setAgeImageBackSideContentType(String ageImageBackSideContentType) {
		this.ageImageBackSideContentType = ageImageBackSideContentType;
	}
	
	public File getAddImageBackSide() {
		return addImageBackSide;
	}

	public void setAddImageBackSide(File addImageBackSide) {
		this.addImageBackSide = addImageBackSide;
	}

	public String getAddImageBackSideFileName() {
		return addImageBackSideFileName;
	}

	public void setAddImageBackSideFileName(String addImageBackSideFileName) {
		this.addImageBackSideFileName = addImageBackSideFileName;
	}

	public String getAddImageBackSideContentType() {
		return addImageBackSideContentType;
	}

	public void setAddImageBackSideContentType(String addImageBackSideContentType) {
		this.addImageBackSideContentType = addImageBackSideContentType;
	}
}
