'''
O(n ^ 2) time Solution
'''

class Solution:
	# @param {string} s
	# @return {integer}
	def minCut(self, s):
		if not s:
			return 0
		dp = [[False for j in range(len(s))] for i in range(len(s))]
		for x in range(len(s)):
			dp[x][x] = True
		for j in range(len(s)):
			for i in range(len(s)):
				if i >= j:
					break
				elif j - i == 1 and s[i] == s[j]:
					dp[i][j] = True
				elif s[i] == s[j] and dp[i + 1][j - 1]:
					dp[i][j] = True
		cut = [len(s) for x in range(len(s) + 1)]
		cut[0] = -1
		for x in range(len(s)):
			for y in range(x + 1):
				if dp[y][x]:
					cut[x + 1] = min(cut[y] + 1, cut[x + 1])
		return cut[len(s)]

sol = Solution()
print sol.minCut("a")