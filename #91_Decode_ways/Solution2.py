'''
case 120
case 0
case 009
'''

class Solution:
	# @param {string} s
	# @return {integer}
	def numDecodings(self, s):
		if not s:
			return 0
		dp = [0 for x in range(len(s))]
		for x in range(0, len(s)):
			if s[x] != '0':
				if x - 1 < 0:
					dp[x] = 1
				else:
					dp[x] = max(dp[x - 1], 1)
			if x - 1 >= 0 and int(s[x - 1: x + 1]) <= 26 and int(s[x - 1: x + 1]) > 9:
				if x - 2 < 0:
					dp[x] += 1
				else:
					dp[x] += max(dp[x - 2], 1)
		return dp[len(s) - 1]

sol = Solution()
print sol.numDecodings("100")