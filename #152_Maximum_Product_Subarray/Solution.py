'''
O(n) time Solution
'''

class Solution:
	# @param {integer[]} nums
	# @return {integer}
	def maxProduct(self, nums):
		if not nums:
			return 0
		maxVal = [0 for x in range(len(nums))]
		minVal = [0 for x in range(len(nums))]
		maxVal[0] = nums[0]
		minVal[0] = nums[0]
		re = maxVal[0]
		for x in range(1, len(nums)):
			maxVal[x] = max(maxVal[x - 1] * nums[x], minVal[x - 1] * nums[x], nums[x])
			minVal[x] = min(maxVal[x - 1] * nums[x], minVal[x - 1] * nums[x], nums[x])
			re = max(re, maxVal[x])
		return re

sol = Solution()
print sol.maxProduct([-2])