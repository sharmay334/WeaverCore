/**
 * 
 */
package com.stpl.pms.hibernate.mapping;

/**
 * @author root
 *
 */
public class StDmAliasAnalyticalToolMapping implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Short id;
	private Short domainId;
	private Short aliasId;
	private String analyticalTool;
	private String property1;
	private String property2;
	private String property3;
	private String property4;
	private String status; 
	
	
	// Constructors

		/** default constructor */
		public StDmAliasAnalyticalToolMapping() {
		}


		public StDmAliasAnalyticalToolMapping(Short domainId, Short aliasId,
				String analyticalTool, String property1, String property2,
				String property3, String property4,String status) {
			
			this.domainId = domainId;
			this.aliasId = aliasId;
			this.analyticalTool = analyticalTool;
			this.property1 = property1;
			this.property2 = property2;
			this.property3 = property3;
			this.property4 = property4;
			this.status=status;
		}


		public Short getId() {
			return id;
		}


		public void setId(Short id) {
			this.id = id;
		}


		public Short getDomainId() {
			return domainId;
		}


		public void setDomainId(Short domainId) {
			this.domainId = domainId;
		}


		public Short getAliasId() {
			return aliasId;
		}


		public void setAliasId(Short aliasId) {
			this.aliasId = aliasId;
		}


		public String getAnalyticalTool() {
			return analyticalTool;
		}


		public void setAnalyticalTool(String analyticalTool) {
			this.analyticalTool = analyticalTool;
		}


		public String getProperty1() {
			return property1;
		}


		public void setProperty1(String property1) {
			this.property1 = property1;
		}


		public String getProperty2() {
			return property2;
		}


		public void setProperty2(String property2) {
			this.property2 = property2;
		}


		public String getProperty3() {
			return property3;
		}


		public void setProperty3(String property3) {
			this.property3 = property3;
		}


		public String getProperty4() {
			return property4;
		}


		public void setProperty4(String property4) {
			this.property4 = property4;
		}		


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}

		
		
}
