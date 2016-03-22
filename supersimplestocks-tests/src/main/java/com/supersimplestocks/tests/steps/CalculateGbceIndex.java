package com.supersimplestocks.tests.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.supersimplestocks.infra.StockService;

@Steps
public class CalculateGbceIndex {

	@Autowired
	StockService stockService;
	
	double GBCEIndex;
	
	@When("I choose the GBCE option")
	public void iChooseTheGBCEOption(){
		GBCEIndex = stockService.calculateGBCE();
	}
	
	@Then("the GBCE index value should be between $min and $max")
	public void theGBCEIndexShouldValueTo(double min, double max){
		assertTrue( max > GBCEIndex && GBCEIndex > min);
	}
}
