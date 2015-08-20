'''
time: O(log(n))
'''

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def findMin(self, nums):
        if len(nums) == 1:
        	return nums[0]
        if len(nums) == 2:
        	return min(nums)
        if nums[0] < nums[len(nums) - 1]:
        	return nums[0]
        mid = (len(nums) - 1) / 2
        if nums[mid] > nums[0]:
        	return self.findMin(nums[mid + 1:])
        if nums[mid] < nums[0]:
        	return self.findMin(nums[:mid + 1])

sol = Solution()
print sol.findMin([2, 3, 4, 5, 0, 1])