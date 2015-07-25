class Solution:
    # @param {integer} k
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, k, prices):
        if (len(prices) < 2 or k == 0):
        	return 0;
        if (k >= len(prices) / 2):
        	result = self.maxTransaction(prices)
        	return result
        dp = [[0] * len(prices) for i in range(k + 1)]
        # WRONG: dp = [[0] * len(prices)] * (k + 1)

        for i in range(1, k + 1):
        	minVal = prices[0]
        	for j in range(1, len(prices)):
        		dp[i][j] = max(dp[i][j - 1], prices[j] - minVal)
        		minVal = min(minVal, prices[j] - dp[i - 1][j - 1])
        return dp[k][len(prices) - 1]

    # @param {integer[]} prices
    # @return {integer}
    def maxTransaction(self, prices):
    	re = 0
    	for x in range(len(prices) - 1):
    		if (prices[x + 1] > prices[x]):
    			re += prices[x + 1] - prices[x]
    	return re

sol = Solution();
t = [3,3,5,0,0,3,1,4]
print sol.maxProfit(2, t)