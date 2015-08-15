class Solution:
	# @param {integer[]} ratings
	# @return {integer}
	def candy(self, ratings):
		if not ratings:
			return 0
		left = [1 for x in range(len(ratings))]
		right = [1 for x in range(len(ratings))]
		for x in range(1, len(left)):
			if ratings[x] > ratings[x - 1]:
				left[x] = left[x - 1] + 1
		for x in range(len(right) - 2, -1, -1):
			if ratings[x] > ratings[x + 1]:
				right[x] = right[x + 1] + 1
		re = 0
		for x in range(len(ratings)):
			re += max(left[x], right[x])
		return re

sol = Solution()
print sol.candy([3, 6, 3, 1])