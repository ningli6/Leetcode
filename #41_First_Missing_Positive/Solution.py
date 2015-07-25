'''
O(n) solution, O(1) space
1. be aware that max missing val is len(nums) + 1
2. use index information along with value itself
3. special case: swap with the same value
'''

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def firstMissingPositive(self, nums):
        if not nums:
        	return 1
        for i in range(len(nums)):
        	while nums[i] != i + 1 and nums[i] > 0 and nums[i] <= len(nums) and nums[i] != nums[nums[i] - 1]:
        		x, y = i, nums[i] - 1
        		tmp = nums[x]
        		nums[x] = nums[y]
        		nums[y] = tmp
        for i, v in enumerate(nums):
        	if i + 1!= v:
        		return i + 1
        return len(nums) + 1

sol = Solution()
print sol.firstMissingPositive([1, 1])