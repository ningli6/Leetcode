'''
DP Solution
dp[i][j]: min step for word1[0, i) and word2[0, j) to transform
word1[i] = c
word2[j] = d
if c == d:
	dp[i][j] = dp[i - 1][j - 1]
else:
	convert c to d: dp[i][j] = dp[i - 1][j - 1] + 1
	insert d after c: dp[i][j] = dp[i][j - 1] + 1
	delete c: dp[i][j] = dp[i - 1][j] + 1

time: O(m * n)
space: O(n)
'''

class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    def minDistance(self, word1, word2):
        dp = [[j + i for j in range(len(word2) + 1)] for i in range(len(word1) + 1)]
        for i in range(1, len(word1) + 1):
        	for j in range(1, len(word2) + 1):
        		if word1[i - 1] == word2[j - 1]:
        			dp[i][j] = dp[i - 1][j - 1]
        		else:
        			dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
        return dp[len(word1)][len(word2)]

sol = Solution()
print sol.minDistance("intention", "execution")