package com.supersimplestocks.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class Stock {
	
	private String symbol;
	private StockTypeEnum type;
	private long lastDividende;
	private double fixedDividend;
	private long parValue;
	
	private List<Trade> trades;
	
	
	public List<Trade> getTrades() {
		return trades;
	}
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public StockTypeEnum getType() {
		return type;
	}
	public void setType(StockTypeEnum type) {
		this.type = type;
	}
	public long getLastDividende() {
		return lastDividende;
	}
	public void setLastDividende(long lastDividende) {
		this.lastDividende = lastDividende;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public long getParValue() {
		return parValue;
	}
	public void setParValue(long parValue) {
		this.parValue = parValue;
	}
	@Override
	public String toString() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("Stock Symbol: ");
		sbuilder.append(getSymbol());
		sbuilder.append(", Type: ");
		sbuilder.append(getType().getDescription());
		sbuilder.append(", Last Dividende: ");
		sbuilder.append(getLastDividende());
		sbuilder.append(", Fixed Dividende: ");
		sbuilder.append(getFixedDividend());
		sbuilder.append(", Par value: ");
		sbuilder.append(getParValue());
		return sbuilder.toString();
	}
	
	
}
