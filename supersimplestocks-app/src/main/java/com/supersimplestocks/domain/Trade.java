package com.supersimplestocks.domain;

import java.util.Date;

public class Trade {
	
	private long id;
	private String stockSymbol;
	private double price;
	private long quantity;
	private Date timeStamp;
	private TradeOperationEnum operation;
	
	
	public Trade() {
		super();
	}
	
	public Trade(long quantity, double price) {
		this.price=price;
		this.quantity=quantity;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public TradeOperationEnum getOperation() {
		return operation;
	}
	public void setOperation(TradeOperationEnum operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("trade stock symbol: ");
		sbuilder.append(getStockSymbol());
		sbuilder.append("\n");
		sbuilder.append("price: "); 
		sbuilder.append(getPrice());
		sbuilder.append("\n");
		sbuilder.append("quantity: ");
		sbuilder.append(getQuantity());
		sbuilder.append("\n");
		sbuilder.append("operation: ");
		sbuilder.append(getOperation());
		sbuilder.append("\n");
		sbuilder.append("Timestamp: ");
		sbuilder.append(getTimeStamp());

		return sbuilder.toString();
	}	
	
	
}
