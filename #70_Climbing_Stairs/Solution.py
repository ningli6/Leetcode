'''
time: O(n)
space: O(1)
'''

class Solution:
	# @param {integer} n
	# @return {integer}
	def climbStairs(self, n):
		if n == 0:
			return 0
		if n < 3:
			return n
		dp0, dp1, dp2 = 1, 2, 0
		for x in range(2, n):
			dp2 = dp0 + dp1
			dp0 = dp1
			dp1 = dp2
		return dp2

sol = Solution()
print sol.climbStairs(3)