package com.supersimplestocks.domain;

public enum StockTypeEnum {
	
	COMMON("Common"), PREFERED("Preferred");
	
	private StockTypeEnum(){}
	
	private StockTypeEnum(String description){
		this.description=description;
	}
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
