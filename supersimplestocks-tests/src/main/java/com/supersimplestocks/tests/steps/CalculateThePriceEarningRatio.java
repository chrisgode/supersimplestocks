package com.supersimplestocks.tests.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.infra.StockService;

@Steps
public class CalculateThePriceEarningRatio {

	private double priceEarningRatio;
	private Stock stock;
	
	@Autowired
	private StockService stockService;
	
	@When("I choose the price earning ratio option for the stock $stockSymbol")
	public void iTypeInStockSymbol(String stockSymbol){
		stock = stockService.getStockBySymbol(stockSymbol);
		priceEarningRatio = stockService.getPriceEarningRatio(stock);
	}
	
	@Then("the stock price earning ratio should be $priceEarningRatio")
	public void theStockPriceEarningRatioShouldBe(double priceEarningRatio){
		assertTrue(this.priceEarningRatio == priceEarningRatio);
	}
}
