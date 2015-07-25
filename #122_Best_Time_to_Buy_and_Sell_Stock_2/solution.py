class Solution:
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, prices):
    	if prices == None or len(prices) == 0:
    		return 0
    	total = 0
    	for i in range(len(prices) - 1):
    		if (prices[i + 1] > prices[i]):
    			total += prices[i + 1] - prices[i]
    	return total