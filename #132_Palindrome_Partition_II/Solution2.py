class Solution:
	# @param {string} s
	# @return {integer}
	def minCut(self, s):
		if not s:
			return 0
		cut = [len(s) for x in range(len(s) + 1)]
		cut[0] = -1
		dp = [[False for j in range(len(s))] for i in range(len(s))]
		for j in range(len(s)):
			for i in range(len(s)):
				if i > j:
					break
				elif (j - i <= 1 or dp[i + 1][j - 1]) and s[i] == s[j]:
					dp[i][j] = True
					cut[j + 1] = min(cut[j + 1], cut[i] + 1)
		return cut[len(s)]

sol = Solution()
print sol.minCut("a")