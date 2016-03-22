package com.supersimplestocks.tests.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.Trade;
import com.supersimplestocks.domain.TradeOperationEnum;
import com.supersimplestocks.infra.StockService;

@Steps
public class RecordATrade {

	Trade trade;
	Stock stock;
	
	@Autowired
	StockService stockService;
	
	@When("I choose to $operation the quantity of $quantity and the price of $price USD for the stock $stockSymbol")
	public void iChooseTheOperation(String operation, Long quantity, double price, String stockSymbol){
		
		stock = stockService.getStockBySymbol(stockSymbol);
		trade = new Trade();
		trade.setQuantity(quantity);
		trade.setPrice(price);
		trade.setStockSymbol(stockSymbol);
		
		if(operation.equalsIgnoreCase(TradeOperationEnum.BUY.getDescription()))
			trade.setOperation(TradeOperationEnum.BUY);
		
		if(operation.equalsIgnoreCase(TradeOperationEnum.SELL.getDescription()))
			trade.setOperation(TradeOperationEnum.SELL);
		
		trade = stockService.addNewTrade(stock, trade);
	}
	
	@Then("the trade should be recorded for the stock $stockSymbol")
	public void theTradeShouldBeRecorded(String stockSymbol){
		
		Stock retrievedStock = stockService.getStockBySymbol(stockSymbol);
		Trade retrievedTrade = null;
		
		boolean isPresent = false;
		
		for (Trade tempTrade : retrievedStock.getTrades()) {
			if(trade.getId()==tempTrade.getId()) {
				isPresent = true;
				retrievedTrade = tempTrade;
			}
		}
		
		assertTrue(isPresent);
		assertNotNull(retrievedTrade.getId());
		assertNotNull(retrievedTrade.getStockSymbol());
	}
}
