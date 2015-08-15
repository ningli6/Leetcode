class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def subsetsWithDup(self, nums):
        if not nums:
        	return []
        re = [[]]
        nums.sort()
        cur = 0
        for x in range(len(nums)):
        	if x == 0 or nums[x] != nums[x - 1]:
        		cur = 0
        	l = len(re)
        	while cur < l:
        		re.append(re[cur] + [nums[x]])
        		cur += 1
        return re

sol = Solution()
print sol.subsetsWithDup([1])