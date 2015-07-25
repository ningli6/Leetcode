'''
Time O(m * n),
Space O(m * n) ->O(m)
1. if dp[i - 1][j - 1] is true and s[i] == p[j] or p[j] == '?' or p[j] == '*', dp[i][j] is true
2. if dp[i - 1][j] is true, and p[j] == '*' and s[i - 1] == s[i], then dp[i][j] is true
3. if dp[i][j - 1] is true, and p[j] == '*', then dp[i][j] is true
'''

class Solution:
	# @param {string} s
	# @param {string} p
	# @return {boolean}
	def isMatch(self, s, p):
		if not s and not p: # both empty
			return True
		if not p: # p is empty string
			return False
		if len(p) - p.count('*') > len(s):
			return False
		dp = [[False for j in range(len(p) + 1)] for i in range(len(s) + 1)]
		dp[0][0] = True
		for j in range(1, len(p) + 1):
			if dp[0][j - 1] and p[j - 1] == '*':
				dp[0][j] = True
		for i in range(1, len(s) + 1):
			for j in range(1, len(p) + 1):
				if dp[i - 1][j - 1] and (s[i - 1] == p[j - 1] or p[j - 1] == '?'):
					dp[i][j] = True
				elif dp[i - 1][j] and p[j - 1] == '*':
					dp[i][j] = True
				elif dp[i][j - 1] and p[j - 1] == '*':
					dp[i][j] = True
		return dp[len(s)][len(p)]

sol = Solution()
print sol.isMatch("abefcdgiescdfimde", "ab*cd?i*de")