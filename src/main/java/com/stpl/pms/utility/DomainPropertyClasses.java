package com.stpl.pms.utility;


public enum DomainPropertyClasses {
			StPmFieldDomainMapping("Registration Page",null,null),
			StPmSecurityQuesMaster("Security Question List",null,null),
			StPmReferenceMaster("Reference List", null,null),
			StCshPaymentOptionsDomainMapping("Cashier Payment Options",null,null),
			StDmBlockedIp("Blocked Ip List",null,null),
			StDmBlockedEmailId("Blocked Email Id List",null,null), 
			StDmBlockedPhoneNo("Blocked Phone No List",null,null),
			StDmDomainCountryMapping("Country List",null,null), 
			StDmDomainStateMapping("State List",null,null),
			StRiskDuplicateMaster("Duplication Check List",null,null), 
			StRiskDuplicateWeightage("Duplicate Weightage List",null,null),
			StPortalMenuMaster("Portal Menu List",null,null), 
			StPortalContentMaster("Portal Content List", null,null),
			StCmsTemplateMaster("Cms Template List",null,null ), 
			StRgOperatorLimit("Rg Operator",null,null),
			StDmDomainWinApproveLimitMaster("Winning Approve Limit","creationTime","lastUpdationTime"),
			StDmDomainLanguageMapping("Language List","creationTime","lastUpdationTime"),
			StDmDomainCurrencyMapping( "Currency List","creationTime","lastUpdationTime") ,
			StVipLevelMaster("VIP List","creationDate","updateDatetime");
			
			private final String displayValue;
			private final String prop1;
			private final String prop2;

			private DomainPropertyClasses(String displayValue,String prop1,String prop2) {
				this.displayValue = displayValue;
				this.prop1 = prop1;
				this.prop2 = prop2;
			}

			public String getDisplayValue() {
				return displayValue;
			}

			public String getProp1() {
				return prop1;
			}

			public String getProp2() {
				return prop2;
			}
			
		}