class Solution:
	# @param {integer} n
	# @return {integer[]}
	def grayCode(self, n):
		if n == 0:
			return [0]
		if n == 1:
			return [0, 1]
		re = [x for x in range(1 << n)]
		for i in range(1, n):
			for j in range(1 << i, 1 << i + 1):
				re[j] = (1 << i) + re[(1 << i + 1) - 1 - j]
		return re

sol = Solution()
print sol.grayCode(3)