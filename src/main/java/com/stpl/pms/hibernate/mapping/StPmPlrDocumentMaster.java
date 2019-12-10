package com.stpl.pms.hibernate.mapping;

import java.io.File;
import java.sql.Timestamp;

import com.stpl.pms.javabeans.PlayerDocumentMasterBean;

/**
 * StPmPlrDocumentMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmPlrDocumentMaster implements java.io.Serializable {

	// Fields
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
	private Timestamp uploadedDate;
	// Constructors

	/** default constructor */
	public StPmPlrDocumentMaster() {
	}

	public StPmPlrDocumentMaster(PlayerDocumentMasterBean plrDocumentMaster) {
		this.docId = plrDocumentMaster.getDocId();
		this.playerId=plrDocumentMaster.getPlayerId();
		this.ageDocType = plrDocumentMaster.getAgeDocType();
		this.ageDocUniqueNo = plrDocumentMaster.getAgeDocUniqueNo();
		this.ageDocPath = plrDocumentMaster.getAgeDocPath();
		this.addDocType = plrDocumentMaster.getAddDocType();
		this.addDocUniqueNo = plrDocumentMaster.getAddDocUniqueNo();
		this.addDocPath = plrDocumentMaster.getAddDocPath();
		this.taxIdDocType = plrDocumentMaster.getTaxIdDocType();
		this.taxIdDocUniqueNo = plrDocumentMaster.getTaxIdDocUniqueNo();
		this.taxIdDocPath = plrDocumentMaster.getTaxIdDocPath();
		this.ageImage=plrDocumentMaster.getAgeImage();
		this.addImage=plrDocumentMaster.getAddImage();
		this.taxIdImage=plrDocumentMaster.getTaxIdImage();
	}

	
	public StPmPlrDocumentMaster(Long docId, Long playerId,
			String ageDocUniqueNo, String ageDocType, String ageDocPath,
			String addDocUniqueNo, String addDocType, String addDocPath,
			String taxIdDocUniqueNo, String taxIdDocType, String taxIdDocPath, Timestamp uploadedDate) {
		super();
		this.docId = docId;
		this.playerId = playerId;
		this.ageDocUniqueNo = ageDocUniqueNo;
		this.ageDocType = ageDocType;
		this.ageDocPath = ageDocPath;
		this.addDocUniqueNo = addDocUniqueNo;
		this.addDocType = addDocType;
		this.addDocPath = addDocPath;
		this.taxIdDocUniqueNo = taxIdDocUniqueNo;
		this.taxIdDocType = taxIdDocType;
		this.taxIdDocPath = taxIdDocPath;
		this.uploadedDate = uploadedDate;
	}

	public Long getDocId() {
		return docId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public String getAgeDocUniqueNo() {
		return ageDocUniqueNo;
	}

	public String getAgeDocType() {
		return ageDocType;
	}

	public String getAgeDocPath() {
		return ageDocPath;
	}

	public String getAddDocUniqueNo() {
		return addDocUniqueNo;
	}

	public String getAddDocType() {
		return addDocType;
	}

	public String getAddDocPath() {
		return addDocPath;
	}

	public String getTaxIdDocUniqueNo() {
		return taxIdDocUniqueNo;
	}

	public String getTaxIdDocType() {
		return taxIdDocType;
	}

	public String getTaxIdDocPath() {
		return taxIdDocPath;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public void setAgeDocUniqueNo(String ageDocUniqueNo) {
		this.ageDocUniqueNo = ageDocUniqueNo;
	}

	public void setAgeDocType(String ageDocType) {
		this.ageDocType = ageDocType;
	}

	public void setAgeDocPath(String ageDocPath) {
		this.ageDocPath = ageDocPath;
	}

	public void setAddDocUniqueNo(String addDocUniqueNo) {
		this.addDocUniqueNo = addDocUniqueNo;
	}

	public void setAddDocType(String addDocType) {
		this.addDocType = addDocType;
	}

	public void setAddDocPath(String addDocPath) {
		this.addDocPath = addDocPath;
	}

	public void setTaxIdDocUniqueNo(String taxIdDocUniqueNo) {
		this.taxIdDocUniqueNo = taxIdDocUniqueNo;
	}

	public void setTaxIdDocType(String taxIdDocType) {
		this.taxIdDocType = taxIdDocType;
	}

	public void setTaxIdDocPath(String taxIdDocPath) {
		this.taxIdDocPath = taxIdDocPath;
	}

	public File getAgeImage() {
		return ageImage;
	}

	public File getAddImage() {
		return addImage;
	}

	public File getTaxIdImage() {
		return taxIdImage;
	}

	public void setAgeImage(File ageImage) {
		this.ageImage = ageImage;
	}

	public void setAddImage(File addImage) {
		this.addImage = addImage;
	}

	public void setTaxIdImage(File taxIdImage) {
		this.taxIdImage = taxIdImage;
	}

	public String getAgeImageFileName() {
		return ageImageFileName;
	}

	public String getAddImageFileName() {
		return addImageFileName;
	}

	public String getTaxIdImageFileName() {
		return taxIdImageFileName;
	}

	public void setAgeImageFileName(String ageImageFileName) {
		this.ageImageFileName = ageImageFileName;
	}

	public void setAddImageFileName(String addImageFileName) {
		this.addImageFileName = addImageFileName;
	}

	public void setTaxIdImageFileName(String taxIdImageFileName) {
		this.taxIdImageFileName = taxIdImageFileName;
	}

	public String getAgeDocVerified() {
		return ageDocVerified;
	}

	public String getAddDocVerified() {
		return addDocVerified;
	}

	public String getTaxIdDocVerified() {
		return taxIdDocVerified;
	}

	public void setAgeDocVerified(String ageDocVerified) {
		this.ageDocVerified = ageDocVerified;
	}

	public void setAddDocVerified(String addDocVerified) {
		this.addDocVerified = addDocVerified;
	}

	public void setTaxIdDocVerified(String taxIdDocVerified) {
		this.taxIdDocVerified = taxIdDocVerified;
	}

	public String getAgeImageContentType() {
		return ageImageContentType;
	}

	public void setAgeImageContentType(String ageImageContentType) {
		this.ageImageContentType = ageImageContentType;
	}

	public String getAddImageContentType() {
		return addImageContentType;
	}

	public void setAddImageContentType(String addImageContentType) {
		this.addImageContentType = addImageContentType;
	}

	public String getTaxIdImageContentType() {
		return taxIdImageContentType;
	}

	public void setTaxIdImageContentType(String taxIdImageContentType) {
		this.taxIdImageContentType = taxIdImageContentType;
	}

	public Timestamp getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Timestamp uploadedDate) {
		this.uploadedDate = uploadedDate;
	}


}
