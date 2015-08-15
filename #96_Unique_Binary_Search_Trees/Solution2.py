'''
O(n ^ 2) dp Solution
'''

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param {integer} n
    # @return {integer}
    def numTrees(self, n):
        if n < 1:
        	return 0
        dp = [1 for x in range(n + 1)]
        for x in range(1, n + 1):
        	dp[x] = 0
        	for k in range(1, x + 1):
        		dp[x] += dp[k - 1] * dp[x - k]
        return dp[n]

sol = Solution()
print sol.numTrees(3)