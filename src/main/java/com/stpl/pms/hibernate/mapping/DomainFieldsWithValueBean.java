package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.util.Map;

public class DomainFieldsWithValueBean extends StPmFieldDomainMapping implements
		Comparable<DomainFieldsWithValueBean>, Cloneable,Serializable{

	private static final long serialVersionUID = 1L;
	private Map<String, String> optionValuesMap;
	
	public DomainFieldsWithValueBean(StPmFieldDomainMapping bean) {
		super(bean.getFieldName(), bean.getFieldDispCode(), bean
				.getPageSectionNo(), bean.getFieldSequenceNo(), bean
				.getIsMandatory(), bean.getValidationExp(), bean
				.getHelpStringCode(), bean.getIsUnique(), bean
				.getFieldInputType(), bean.getOptionValues(), bean
				.getSectionNameCode(), bean.getIsEditablePlayer(), bean
				.getDefaultValue(), bean.getIsPartOfMiniReg(), bean
				.getMiniRegSeqNo());
	}

	public DomainFieldsWithValueBean(String fieldName, Integer fieldDispCode,
			Short pageSectionNo, Short fieldSequenceNo, String isMandatory,
			String validationExp, Integer helpStringCode, String isUnique,
			String fieldInputType, String optionValues,
			Integer sectionNameCode, String isEditablePlayer,
			String defaultValue, String isPartOfMiniReg, Short miniRegSeqNo) {
		super(fieldName, fieldDispCode, pageSectionNo, fieldSequenceNo,
				isMandatory, validationExp, helpStringCode, isUnique,
				fieldInputType, optionValues, sectionNameCode,
				isEditablePlayer, defaultValue, isPartOfMiniReg, miniRegSeqNo);
	}

	public DomainFieldsWithValueBean(Integer fieldId, String fieldName,
			Integer fieldDispCode, Short pageSectionNo, Short fieldSequenceNo,
			String isMandatory, String validationExp, Integer helpStringCode,
			String fieldInputType, String optionValues,
			Integer sectionNameCode, String defaultValue, String isEditable, String isPartOfMiniReg, Short miniRegSeqNo) {
		super(fieldId, fieldName, fieldDispCode, pageSectionNo,
				fieldSequenceNo, isMandatory, validationExp, helpStringCode,
				fieldInputType, optionValues, sectionNameCode, defaultValue,
				isEditable,isPartOfMiniReg,miniRegSeqNo);
	}


	public DomainFieldsWithValueBean() {
		super();
	}

	public int compareTo(DomainFieldsWithValueBean o) {

		if (this.getFieldDispCode().equals(o.getFieldDispCode())
				&& this.getPageSectionNo().equals(o.getPageSectionNo())
				&& this.getFieldSequenceNo().equals(o.getFieldSequenceNo())
				&& this.getIsMandatory().equals(o.getIsMandatory())
				&& this.getSectionNameCode().equals(o.getSectionNameCode())
				&& this.getIsPartOfMiniReg().equals(o.getIsPartOfMiniReg())
				&& this.getMiniRegSeqNo().equals(o.getMiniRegSeqNo()))
			return 1;

		else
			return 0;
	}

	public DomainFieldsWithValueBean clone() throws CloneNotSupportedException {
		return (DomainFieldsWithValueBean) super.clone();

	}

	public void setOptionValuesMap(Map<String, String> optionValuesMap) {
		this.optionValuesMap = optionValuesMap;
	}

	public Map<String, String> getOptionValuesMap() {

		return optionValuesMap;
	}
}
