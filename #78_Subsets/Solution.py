'''
Bit manipulation
O(n * 2^n)
'''

class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def subsets(self, nums):
        if not nums:
        	return []
        nums.sort()
        subSet = [[] for x in range(1 << len(nums))]
        for i in range(len(nums)):
        	for j in range(1 << len(nums)):
        		if j & (1 << (len(nums) - 1 - i)):
        			subSet[j].append(nums[i])
        return subSet

sol = Solution()
print sol.subsets([1, 2, 3])