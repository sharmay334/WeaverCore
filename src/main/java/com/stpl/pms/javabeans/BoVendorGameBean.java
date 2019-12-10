package com.stpl.pms.javabeans;


import com.stpl.pms.hibernate.mapping.StPortalGameDomainRoleMapping;

public class BoVendorGameBean implements Cloneable,java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer gameId;
	private String gameName;
	private String gameNumber;
	private String gameType;
	private String gameImagePath;
	private Double gamePrice;
	private String gameDesc;
	private Short windowHeight;
	private Short windowWidth;
	private Short vendorId;
    private String vendorName;
    private Integer gameGroupId;
    private String gameGroupName;
	private String propertyValue;
	private String urlParameter;
	private String isFlash;
	private String isHtml5;
	private Integer showOrder;
	private String status;
	private String themeName;
	private Integer themeId;

	public BoVendorGameBean(){
	  super();	
	}

	public BoVendorGameBean(Integer gameId){
		  super();
		  this.gameId = gameId;
	}
	public BoVendorGameBean(Integer gameId, String gameName,
			String gameNumber, String gameType, Double gamePrice, Short vendorId, String vendorName,String gameGroupName,String status ) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameType = gameType;
		this.gamePrice = gamePrice;
		this.vendorId = vendorId;
		this.vendorName=vendorName;
		this.gameGroupName=gameGroupName;
		this.status=status;
	}
	public BoVendorGameBean(Integer gameId, String gameName,
			String gameNumber, String gameType, Double gamePrice, Short vendorId, String vendorName,String gameGroupName,String themeName,Integer themeId,String status,Integer showOrder ) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameType = gameType;
		this.gamePrice = gamePrice;
		this.vendorId = vendorId;
		this.vendorName=vendorName;
		this.gameGroupName=gameGroupName;
		this.themeName=themeName;
		this.themeId=themeId;
		this.status=status;
		this.showOrder=showOrder;
	}
	public BoVendorGameBean(Integer gameId, String gameName,
			String gameType,String gameGroupType, Short vendorId,String status) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameType = gameType;
		this.vendorId = vendorId;
		this.gameGroupName=gameGroupType;
		this.status=status;
	}
	public BoVendorGameBean(Integer gameId, String gameName,
			String gameNumber, String gameType, Double gamePrice,
			String gameGroupType, String themeName, Integer themeId,
			String status, Integer showOrder) {
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameNumber = gameNumber;
		this.gameType = gameType;
		this.gamePrice = gamePrice;
		this.gameGroupName=gameGroupType;
		this.themeName = themeName;
		this.themeId = themeId;
		this.status=status;
		this.showOrder = showOrder;
	}

	public Integer getGameId() {
		return gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public String getGameNumber() {
		return gameNumber;
	}
	public String getGameType() {
		return gameType;
	}
	public String getGameImagePath() {
		return gameImagePath;
	}
	public Double getGamePrice() {
		return gamePrice;
	}

	public String getGameDesc() {
		return gameDesc;
	}
	public Short getWindowHeight() {
		return windowHeight;
	}
	public Short getWindowWidth() {
		return windowWidth;
	}
	public Short getVendorId() {
		return vendorId;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public String getUrlParameter() {
		return urlParameter;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public void setGameImagePath(String gameImagePath) {
		this.gameImagePath = gameImagePath;
	}
	public void setGamePrice(Double gamePrice) {
		this.gamePrice = gamePrice;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc;
	}
	public void setWindowHeight(Short windowHeight) {
		this.windowHeight = windowHeight;
	}
	public void setWindowWidth(Short windowWidth) {
		this.windowWidth = windowWidth;
	}
	public void setVendorId(Short vendorId) {
		this.vendorId = vendorId;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public void setUrlParameter(String urlParameter) {
		this.urlParameter = urlParameter;
	}
	public String getIsFlash() {
		return isFlash;
	}
	public String getIsHtml5() {
		return isHtml5;
	}
	public void setIsFlash(String isFlash) {
		this.isFlash = isFlash;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
	public void setIsHtml5(String isHtml5) {
		this.isHtml5 = isHtml5;
	}

	public String getVendorName() {
		return vendorName;
	}

	public Integer getGameGroupId() {
		return gameGroupId;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setGameGroupId(Integer gameGroupId) {
		this.gameGroupId = gameGroupId;
	}

	public String getGameGroupName() {
		return gameGroupName;
	}

	public void setGameGroupName(String gameGroupName) {
		this.gameGroupName = gameGroupName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getThemeName() {
		return themeName;
	}

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gameId == null) ? 0 : gameId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		StPortalGameDomainRoleMapping gameBean = (StPortalGameDomainRoleMapping) obj;
		return this.gameId.equals(gameBean.getStPortalGamesMaster().getGameId());
	}

	@Override
	public String toString() {
		return "BoVendorGameBean [gameDesc=" + gameDesc + ", gameGroupId="
				+ gameGroupId + ", gameGroupName=" + gameGroupName
				+ ", gameId=" + gameId + ", gameImagePath=" + gameImagePath
				+ ", gameName=" + gameName + ", gameNumber=" + gameNumber
				+ ", gamePrice=" + gamePrice + ", gameType=" + gameType
				+ ", isFlash=" + isFlash + ", isHtml5=" + isHtml5
				+ ", propertyValue=" + propertyValue + ", showOrder="
				+ showOrder + ", status=" + status + ", themeId=" + themeId
				+ ", themeName=" + themeName + ", urlParameter=" + urlParameter
				+ ", vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", windowHeight=" + windowHeight + ", windowWidth="
				+ windowWidth + "]";
	}
	
	

}
