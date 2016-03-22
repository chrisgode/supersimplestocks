feature: calculate a stock price
In order to manage assets
As a trader
I want know the price of a stock

Given the stocks have no trade
Given the stock POP has had a trade of 10 shares at 120 USD in the past 15 mn
Given the stock POP has had a trade of 5 shares at 118 USD in the past 15 mn
Given the stock POP has had a trade of 2 shares at 125 USD in the past 15 mn
When I choose the price option for the POP stock
Then I should get the price 120 of the POP stock