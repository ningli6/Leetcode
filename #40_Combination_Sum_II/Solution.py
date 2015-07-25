'''
1. If duplicates exist, need to skip the later ones to avoid duplicates in result
2. Must stop search once sum is too large or find a match
'''

class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}
    def combinationSum2(self, candidates, target):
        if not candidates:
        	return []
        candidates.sort() # sort the array
        re = []
        self.bt(candidates, target, [], re) # backtracing
        return re

    def bt(self, nums, target, tmp, result):
    	if not nums:
    		return
    	for x in range(len(nums)): # for each number
    		if x > 0 and nums[x] == nums[x - 1]: # skip if this one is the same as last
    			continue
    		if target < nums[x]:   # sum is too large, return because following elements are larger
    			return
    		tmp.append(nums[x])
    		 # happens to match, use list to create a hard copy and return immediately to avoid duplicates
    		 # this check must be done before entering deeper stack to avoid duplicates
    		if target == nums[x]: 
    			result.append(list(tmp))
    			tmp.pop()
    			return
    		self.bt(nums[x + 1:], target - nums[x], tmp, result) # bt
    		tmp.pop()


sol = Solution()
t= [10,1,2,7,6,1,5]
print sol.combinationSum2(t, 8)