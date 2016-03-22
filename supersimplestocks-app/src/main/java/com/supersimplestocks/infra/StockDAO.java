package com.supersimplestocks.infra;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.Trade;

@Component
public interface StockDAO {

	public Stock getStockBySymbol(String stockSymbol);

	public Trade addNewTradeToOrder(Stock stock, Trade trade);
	
	public Map<String, Stock> getAllStock();

	public void deleteAllTrades();
}
