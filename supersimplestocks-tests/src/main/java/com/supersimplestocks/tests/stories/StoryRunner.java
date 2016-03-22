package com.supersimplestocks.tests.stories;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.supersimplestocks.tests.AcceptanceTest;

@RunWith(SpringJUnit4ClassRunner.class)
@AcceptanceTest
public class StoryRunner extends AbstractSpringJBehaveConfig {

	@Override
	protected List<String> storyPaths() {
        String codeLocation = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
        
        return new StoryFinder().findPaths(codeLocation, 
        		Arrays.asList("**/calculate_a_stock_price.story",
        					  "**/calculate_gbce_index.story",
        					  "**/calculate_the_dividende_yield.story",
        					  "**/calculate_the_price_earning_ratio.story",
        					  "**/record_a_trade.story"),
        		Arrays.asList(""), null);
	}
}
