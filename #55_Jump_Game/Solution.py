'''
Greedy, O(n) Solution
'''

class Solution:
	# @param {integer[]} nums
	# @return {boolean}
	def canJump(self, nums):
		if not nums:
			return True
		maxIndex, cur = 0, 0
		while cur < len(nums) and cur <= maxIndex:
			maxIndex = max(nums[cur] + cur, maxIndex)
			cur += 1
		return cur == len(nums)

sol = Solution()
print sol.canJump([2,3,1,1,4])