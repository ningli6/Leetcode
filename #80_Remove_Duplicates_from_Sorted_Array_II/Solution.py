'''
dup can be set to 0 only when nums[j] is not equal to nums[i - 1]
'''

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if not nums:
        	return 0
        i, j, dup = 0, 0, 0
        while j < len(nums) and i <= j:
        	if i > 0 and nums[i - 1] == nums[j]:
        		dup += 1
        	else:
        		dup = 0
        	if dup >= 2:
        		j += 1
        	else:
        		nums[i] = nums[j]
        		i += 1
        		j += 1
        return i

sol = Solution()
print sol.removeDuplicates([1, 1, 1, 1, 2, 2, 3])