class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
        	return 0
        maxSide = 0
        dp = [[0 for j in range(len(matrix[0]))] for i in range(len(matrix))]
        for j in range(len(matrix[0])):
        	if matrix[0][j] == '1':
        		dp[0][j] = 1
        		maxSide = max(maxSide, dp[0][j])
        for i in range(len(matrix)):
        	if matrix[i][0] == '1':
        		dp[i][0] = 1
        		maxSide = max(maxSide, dp[i][0])
        for i in range(1, len(matrix)):
        	for j in range(1, len(matrix[0])):
        		if matrix[i][j] == '0':
        			continue
        		dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
        		maxSide = max(maxSide, dp[i][j])
        return maxSide * maxSide

sol = Solution()
t = [['0', '1'], 
	['1', '0']]
print sol.maximalSquare(t)