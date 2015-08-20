import sys

class Solution:
    # @param {integer[][]} dungeon
    # @return {integer}
    def calculateMinimumHP(self, dungeon):
        if not dungeon or not dungeon[0]:
        	return 0
        row = len(dungeon)
        col = len(dungeon[0])
        dp = [[sys.maxint for j in range(col + 1)] for i in range(row + 1)]
        dp[row][col - 1] = 1
        for j in range(col - 1, -1, -1):
        	for i in range(row - 1, -1, -1):
        		dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])
        return dp[0][0]

sol = Solution()
# t = [[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]
t = [[-2]]
print sol.calculateMinimumHP(t)