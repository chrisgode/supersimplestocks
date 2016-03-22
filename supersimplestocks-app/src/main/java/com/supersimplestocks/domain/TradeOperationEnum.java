package com.supersimplestocks.domain;

public enum TradeOperationEnum {

	BUY("buy"), SELL("sell");
	
	private TradeOperationEnum(String description){
		this.description=description;
	}
	
	private TradeOperationEnum(){
	}
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
