package com.supersimplestocks.infra;

import org.springframework.stereotype.Component;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.Trade;

@Component
public interface StockService {
	
	public Stock getStockBySymbol(String stockSymbol);

	public double getDividendeYiel(Stock stock);

	public Trade addNewTrade(Stock stock, Trade trade);

	public double getPriceEarningRatio(Stock stock);

	public double calculateStockPrice(Stock stock);

	public double calculateGBCE();

	public void deleteAllTrades();
}
