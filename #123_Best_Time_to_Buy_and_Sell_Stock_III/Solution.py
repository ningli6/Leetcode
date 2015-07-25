class Solution:
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, prices):
    	if len(prices) < 2:
    		return 0
    	dp0 = [0] * len(prices)
    	minVal = prices[0]
    	for x in range(1, len(prices)):
    		dp0[x] = max(dp0[x - 1], prices[x] - minVal)
    		minVal = min(minVal, prices[x])
    	dp1 = [0] * len(prices)
    	maxVal = prices[len(prices) - 1]
    	for x in range(len(prices) - 2, -1, -1):
    		dp1[x] = max(dp1[x + 1], maxVal - prices[x])
    		maxVal = max(maxVal, prices[x])
    	re = 0;
    	for x in range(len(prices) - 1):
    		re = max(re, dp0[x] + dp1[x + 1])
    	return max(re, dp0[len(prices) - 1], dp1[0])


sol = Solution()
t = [3, 5, 7, 2, 5]
print sol.maxProfit(t)