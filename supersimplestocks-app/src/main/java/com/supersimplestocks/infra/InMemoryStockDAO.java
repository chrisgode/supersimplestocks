package com.supersimplestocks.infra;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.StockTypeEnum;
import com.supersimplestocks.domain.Trade;

@Repository("stockDAO")
public class InMemoryStockDAO implements StockDAO{
	
	private Map<String, Stock> inMemoryStockList;
	
	public InMemoryStockDAO() {
		
		inMemoryStockList = new HashMap<String, Stock>();
		
		Stock stock = new Stock();
		stock.setSymbol("TEA");
		stock.setType(StockTypeEnum.COMMON);
		stock.setLastDividende(0);
		stock.setParValue(100L);
		
		inMemoryStockList.put(stock.getSymbol(), stock);
		
		stock = new Stock();
		stock.setSymbol("POP");
		stock.setType(StockTypeEnum.COMMON);
		stock.setLastDividende(8);
		stock.setParValue(100L);
		
		inMemoryStockList.put(stock.getSymbol(), stock);
		
		stock = new Stock();
		stock.setSymbol("ALE");
		stock.setType(StockTypeEnum.COMMON);
		stock.setLastDividende(23);
		stock.setParValue(60L);
		
		inMemoryStockList.put(stock.getSymbol(), stock);
		
		stock = new Stock();
		stock.setSymbol("GIN");
		stock.setType(StockTypeEnum.PREFERED);
		stock.setLastDividende(23);
		stock.setParValue(100L);
		
		inMemoryStockList.put(stock.getSymbol(), stock);
		
		stock = new Stock();
		stock.setSymbol("JOE");
		stock.setType(StockTypeEnum.COMMON);
		stock.setLastDividende(13);
		stock.setParValue(250L);
		
		inMemoryStockList.put(stock.getSymbol(), stock);
	}

	public Stock getStockBySymbol(String stockSymbol) {
		
		if(inMemoryStockList.containsKey(stockSymbol)) return inMemoryStockList.get(stockSymbol);
		/*else*/ return null;
	}

	
	@Override
	public Trade addNewTradeToOrder(Stock stock, Trade trade) {
		
		if(stock.getTrades()==null) stock.setTrades(new ArrayList<Trade>());
		trade.setTimeStamp(new Date());
		List<Trade> trades = stock.getTrades();
		
		long id = trades.size()+1;// generate a new id
		trade.setId(id);
		trade.setStockSymbol(stock.getSymbol());
		trades.add(trade);
		
		return trade;
	}

	public Map<String, Stock> getAllStock() {
		return inMemoryStockList;
	}

	@Override
	public void deleteAllTrades() {
		
		Iterator<Stock> it = inMemoryStockList.values().iterator();
		
		while (it.hasNext())
		{
		  Stock currentStock = it.next();
		  currentStock.setTrades(new ArrayList<Trade>());
		}
	}
}
