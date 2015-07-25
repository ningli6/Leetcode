'''
time: O(m * n)
space: O(n)
'''

class Solution:
	# @param {integer[][]} obstacleGrid
	# @return {integer}
	def uniquePathsWithObstacles(self, obstacleGrid):
		if not obstacleGrid or not obstacleGrid[0]:
			return 0
		m = len(obstacleGrid)
		n = len(obstacleGrid[0])
		if obstacleGrid[0][0] == 1:
			return 0
		dp = [0 for j in range(n)]
		k = 0
		while k < n and obstacleGrid[0][k] == 0:
			dp[k] = 1
			k += 1
		for i in range(1, m):
			if obstacleGrid[i][0] == 1:
				dp[0] = 0
			for j in range(1, n):
				dp[j] = dp[j - 1] + dp[j]
				if obstacleGrid[i][j] == 1:
					dp[j] = 0
		return dp[n - 1]

sol = Solution()
print sol.uniquePathsWithObstacles([[0]])