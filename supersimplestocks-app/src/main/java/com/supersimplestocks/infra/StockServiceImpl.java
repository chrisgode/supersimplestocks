package com.supersimplestocks.infra;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.StockTypeEnum;
import com.supersimplestocks.domain.Trade;

@Service("stockService")
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockDAO stockDAO;
	
	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public StockServiceImpl() {
		super();
	}
	
	@Override
	public Stock getStockBySymbol(String stockSymbol) {
		return stockDAO.getStockBySymbol(stockSymbol);
	}

	@Override
	public double getDividendeYiel(Stock stock) {
		
		double dividendeYield = 0.0;
		double tickerPrice = getLastTickerPrice(stock);
		
		if(stock.getType().equals(StockTypeEnum.COMMON)){
			dividendeYield = (stock.getLastDividende()/tickerPrice);
		}else if(stock.getType().equals(StockTypeEnum.PREFERED)){
			dividendeYield = (stock.getFixedDividend()*stock.getParValue()/tickerPrice);
		}
		
		return dividendeYield;
	}

	private double getLastTickerPrice(Stock stock) {
		
		double lastTickerPrice = 0.0;
		Trade lastTrade;
		List<Trade> trades = stock.getTrades();
		
		if(trades!=null && trades.size()>0){
			lastTrade = trades.get(trades.size()-1);
			lastTickerPrice = lastTrade.getPrice();
			
		}else{
			
			// For the purpose of this exercice, I infered that, if no trade exist for the stock,
			// we must use the Par Value to calculate the stock yield
			// but this is something that should be verified on a business perspective
			lastTickerPrice = stock.getParValue();
		}
		
		return lastTickerPrice;
	}

	@Override
	public Trade addNewTrade(Stock stock, Trade trade) {
		return stockDAO.addNewTradeToOrder(stock, trade);
	}

	@Override
	public double getPriceEarningRatio(Stock stock) {
		// Not sure if fixed dividend should be included for type prefered
		// This should be checked
		return (getLastTickerPrice(stock)/stock.getLastDividende());
	}

	@Override
	public double calculateStockPrice(Stock stock) {
		
		Long totalQuantity = 0L;
		double totalPriceQuantity = 0;
		double price = 0;
		
		for(Trade trade: stock.getTrades()){
			
			Long tradeMillis = trade.getTimeStamp().getTime();
			Long nowMillis = new Date().getTime();
			Long fifteenMnMillis = 900000L;
			
			if((nowMillis - tradeMillis) < fifteenMnMillis){
				// The trade has been recorded in the past 15 mn
				totalQuantity += trade.getQuantity();
				totalPriceQuantity += (trade.getQuantity()*trade.getPrice());
			}
		}
		
		price = (totalPriceQuantity / totalQuantity) ;
		
		return price;
	}

	@Override
	public double calculateGBCE() {
		
		List<Stock> stockList = new ArrayList<Stock>(stockDAO.getAllStock().values());
		double stockPricesMulti = 1;
		double n = 0;
		
		for(Stock stock: stockList){
			double stockPrice = calculateStockPrice(stock);
			stockPricesMulti = stockPricesMulti * stockPrice;
			n++;
		}
		
		double GBCE = Math.pow(stockPricesMulti, 1/n);
		
		return GBCE;
	}

	@Override
	public void deleteAllTrades() {
		stockDAO.deleteAllTrades();		
	}
}