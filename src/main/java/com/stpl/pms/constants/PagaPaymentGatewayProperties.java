package com.stpl.pms.constants;

public enum PagaPaymentGatewayProperties {
	p14(14),p15(15),p16(16),p17(17),p18(18),p19(19),p20(20),p21(21),p22(22);
	
	private Integer id;
	
	PagaPaymentGatewayProperties(Integer id){
		this.id = id;
	}
	
	public Integer getPropertyId(){
		return id;
	}
}
