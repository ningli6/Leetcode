'''
DP solution:
dp[i][j] matches if:
1. dp[i - 1][j - 1] matches and char at s[i - 1], p[j - 1] matches
2. dp[i][j - 2] match and p[j - 1] is a star
'''

class Solution:
	# @param {string} s
	# @param {string} p
	# @return {boolean}
	def isMatch(self, s, p):
		if not s and not p:
			return True
		if s and not p:
			return False
		dp = [[False for j in range(len(p) + 1)] for i in range(len(s) + 1)]
		dp[0][0] = True
		for i in range(1, len(p) + 1):
			if p[i - 1] == '*':
				dp[0][i] = dp[0][i - 2]
		for i in range(1, len(s) + 1):
			for j in range(1, len(p) + 1):
				if dp[i - 1][j - 1] and (s[i - 1] == p[j - 1] or p[j - 1] == '.'):
					dp[i][j] = True
					continue
				if dp[i - 1][j] and p[j - 1] == '*' and j > 1 and (s[i - 1] == p[j - 2] or p[j - 2] == '.'):
					dp[i][j] = True
					continue
				if j > 1 and dp[i][j - 2] and p[j - 1] == '*':
					dp[i][j] = True
		return dp[len(s)][len(p)]


sol = Solution()
print sol.isMatch("a", "a*")