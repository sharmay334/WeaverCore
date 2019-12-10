package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvatarUploadResponseBean extends CommonResponseBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String avatarPath;

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

}
