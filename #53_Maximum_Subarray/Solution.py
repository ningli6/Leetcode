'''
DP Solution
time O(n), space O(1)
'''

class Solution:
	# @param {integer[]} nums
	# @return {integer}
	def maxSubArray(self, nums):
		if not nums:
			return 0
		prevMax = nums[0]
		ans = prevMax
		for x in range(1, len(nums)):
			prevMax = max(nums[x], prevMax + nums[x])
			ans = max(ans, prevMax)
		return ans

sol = Solution()
print sol.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4])