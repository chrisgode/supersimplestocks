package com.supersimplestocks.tests.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.infra.StockService;

@Steps
public class CalculateTheDividendeYield {

	Stock stock;
	
	@Autowired
	StockService stockService;
	
	
	@When("I type in the $stockSymbol symbol")
	public void iTypeInStockSymbol(String stockSymbol){
		
		stock = stockService.getStockBySymbol(stockSymbol);
	}
	
	@Then("the stock dividende yield should be $dividendeYield")
	public void theProgramShouldCalculateTheDividendeYield(double dividendeYield){
		
		assertTrue(stockService.getDividendeYiel(stock) == dividendeYield);
	}
}
