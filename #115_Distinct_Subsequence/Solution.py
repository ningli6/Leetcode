class Solution:
	# @param {string} s
	# @param {string} t
	# @return {integer}
	def numDistinct(self, s, t):
		if not t:
			return 1
		if not s:
			return 0
		if len(s) < len(t):
			return 0
		dp = [[0 for j in range(len(t) + 1)] for i in range(len(s) + 1)]
		for i in range(len(s) + 1):
			dp[i][0] = 1  # initialize, empty t matches all s
		for i in range(1, len(s) + 1):
			for j in range(1, len(t) + 1):
				if j > i: # t is longer than s
					continue
				if t[j - 1] == s[i - 1]:
					dp[i][j] = dp[i - 1][j - 1] # use the char at i
				dp[i][j] += dp[i - 1][j] # delete char at i
		return dp[len(s)][len(t)]

sol = Solution()
print sol.numDistinct("rabbbit", "rabbit")