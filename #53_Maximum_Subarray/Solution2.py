'''
Divide and conquer approach

Time: O(n * log(n))
'''

class Solution:
	def maxSubArray(self, nums):
		if not nums:
			return 0
		if len(nums) == 1:
			return nums[0]
		mid = len(nums) / 2
		leftans = self.maxSubArray(nums[:mid])
		rightans = self.maxSubArray(nums[mid:])
		leftmax = 0
		tmp = 0
		for x in range(mid - 1, -1, -1):
			tmp += nums[x]
			leftmax = max(leftmax, tmp)
		tmp = 0
		rightmax = 0
		for x in range(mid + 1, len(nums)):
			tmp += nums[x]
			rightmax = max(rightmax, tmp)
		return max(leftans, rightans, nums[mid] + leftmax + rightmax)

sol = Solution()
print sol.maxSubArray([1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4])