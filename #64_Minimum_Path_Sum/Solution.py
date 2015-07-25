class Solution:
	# @param {integer[][]} grid
	# @return {integer}
	def minPathSum(self, grid):
		if not grid or not grid[0]:
			return 0
		rows = len(grid)     # rows
		cols = len(grid[0])  # cols
		dp = [[0 for j in range(cols)] for i in range(rows)]
		dp[0][0] = grid[0][0]
		for j in range(1, cols):
			dp[0][j] = grid[0][j] + dp[0][j - 1]
		for i in range(1, rows):
			dp[i][0] = grid[i][0] + dp[i - 1][0]
		for i in range(1, rows):
			for j in range(1, cols):
				dp[i][j] = min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j])
		return dp[rows - 1][cols - 1]

sol = Solution()
print sol.minPathSum([[1, 2, 5], [3, 2, 1]])