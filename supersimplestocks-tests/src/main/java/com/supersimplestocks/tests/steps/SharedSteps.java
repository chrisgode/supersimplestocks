package com.supersimplestocks.tests.steps;

import org.jbehave.core.annotations.Given;
import org.springframework.beans.factory.annotation.Autowired;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.Trade;
import com.supersimplestocks.infra.StockService;

@Steps
public class SharedSteps {

	@Autowired
	StockService stockService;
	
	@Given("the stocks have no trade")
	public void theStocksHaveNoTrade(){
		stockService.deleteAllTrades();
	}
	
	@Given("the stock $stockSymbol has had a trade of $quantity shares at $price USD in the past 15 mn")
	public void theStockHasHadATradeInThePast15Mn(String stockSymbol, long quantity, double price){
		
		Stock stock = stockService.getStockBySymbol(stockSymbol);
		Trade trade = new Trade(quantity, price);
		trade = stockService.addNewTrade(stock, trade);
	}	

}
