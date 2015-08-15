import sys

class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if not triangle:
        	return 0
        dp = [0 for j in range(len(triangle))]
        for x in range(len(triangle)):
        	for y in range(x + 1):
        		if x == 0:
        			ul, ur = 0, 0
        		elif y == 0:
        			ul = sys.maxint
        			ur = dp[y]
        		elif y == x:
        			ul = tmp
        			ur = sys.maxint
        		else:
        			ul = tmp
        			ur = dp[y]
        		tmp2 = dp[y]
        		dp[y] = triangle[x][y] + min(ul, ur)
        		tmp = tmp2
        return min(dp)

sol = Solution()
tri = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
print sol.minimumTotal(tri)