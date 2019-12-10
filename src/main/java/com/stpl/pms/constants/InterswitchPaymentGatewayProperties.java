package com.stpl.pms.constants;

public enum InterswitchPaymentGatewayProperties {
	p1(1),p2(2),p3(3),p4(4),p5(5),p6(6),p7(7),p8(8),p9(9),p10(10),p11(11),p12(12),p13(13);
	
	private Integer id;
	
	InterswitchPaymentGatewayProperties(Integer id){
		this.id = id;
	}
	
	public Integer getPropertyId(){
		return id;
	}
}
