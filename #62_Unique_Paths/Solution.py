'''
time: O(m * n)
space: O(n)
'''

class Solution:
	# @param {integer} m
	# @param {integer} n
	# @return {integer}
	def uniquePaths(self, m, n):
		if m <= 0 or n <= 0:
			return 0
		dp = [1 for j in range(n)]
		for i in range(1, m):
			for j in range(1, n):
				dp[j] = dp[j - 1] + dp[j]
		return dp[n - 1]