feature: calculate the GBCE index
In order estimate GBCE asset value
As a user
I want know the value of the GBCE index

Given the stocks have no trade
Given the stock TEA has had a trade of 15 shares at 120 USD in the past 15 mn
Given the stock TEA has had a trade of 10 shares at 118 USD in the past 15 mn
Given the stock POP has had a trade of 10 shares at 120 USD in the past 15 mn
Given the stock POP has had a trade of 5 shares at 118 USD in the past 15 mn
Given the stock POP has had a trade of 2 shares at 125 USD in the past 15 mn
Given the stock ALE has had a trade of 20 shares at 105 USD in the past 15 mn
Given the stock ALE has had a trade of 50 shares at 95 USD in the past 15 mn
Given the stock GIN has had a trade of 5 shares at 195 USD in the past 15 mn
Given the stock GIN has had a trade of 50 shares at 205 USD in the past 15 mn
Given the stock JOE has had a trade of 2 shares at 25 USD in the past 15 mn
When I choose the GBCE option
Then the GBCE index value should be between 93.48 and 93.49
