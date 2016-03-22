package com.supersimplestocks.tests.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.infra.StockService;

@Steps
public class CalculateAStockPrice {
		
	double stockPrice;
	
	@Autowired
	StockService stockService;
	
	@When("I choose the price option for the $stockSymbol stock")
	public void iTypeInStockSymbol(String stockSymbol){
		
		Stock stock = stockService.getStockBySymbol(stockSymbol);
		stockPrice = stockService.calculateStockPrice(stock);
	}
	
	@Then("I should get the price $price of the POP stock")
	public void theProgramShouldCalculateTheDividendeYield(double price){
		assertTrue(price == stockPrice);
	}
}
