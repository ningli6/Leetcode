class Solution:
    # @param {string} s1
    # @param {string} s2
    # @param {string} s3
    # @return {boolean}
    def isInterleave(self, s1, s2, s3):
    	if not s1:
    		return s2 == s3
    	if not s2:
    		return s1 == s3
        if len(s1) + len(s2) != len(s3):
        	return False
        # s1, s2, s3 are not empty strings by now
        dp = [[False for j in range(len(s2) + 1)] for i in range(len(s1) + 1)]
        dp[0][0] = True
        for j in range(1, len(dp[0])):
        	if s2[j - 1] == s3[j - 1]:
        		dp[0][j] = True
        	else:
        		break
        for i in range(1, len(dp)):
        	if s1[i - 1] == s3[i - 1]:
        		dp[i][0] = True
        	else:
        		break
        for i in range(1, len(dp)):
        	for j in range(1, len(dp[0])):
        		dp[i][j] = (dp[i - 1][j] and s1[i - 1] == s3[i + j - 1]) or (dp[i][j - 1] and s2[j - 1] == s3[i + j - 1])
        return dp[len(s1)][len(s2)]

sol = Solution()
print sol.isInterleave('aabcc', 'dbbca', 'aadbbbaccc')