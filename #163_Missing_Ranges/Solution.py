class Solution:
    # @param {integer[]} nums
    # @param {integer} lower
    # @param {integer} upper
    # @return {string[]}
    def findMissingRanges(self, nums, lower, upper):
        if not nums:
        	if lower == upper:
        		return [str(lower)]
        	return [str(lower) + '->' + str(upper)]
        re = []
        if lower < nums[0]:
    		ub = nums[0] - 1
    		lb = lower
    		if ub == lb:
    			re.append(str(lb))
        	elif ub > lb:
        		re.append(str(lb) + '->' + str(ub))
        for x in range(len(nums) - 1):
    		ub = nums[x + 1] - 1
    		lb = nums[x] + 1
    		if ub == lb:
    			re.append(str(lb))
    		elif ub > lb:
    			re.append(str(lb) + '->' + str(ub))
    	if nums[len(nums) - 1] < upper:
    		ub = upper
    		lb = nums[len(nums) - 1] + 1
    		if ub == lb:
    			re.append(str(lb))
    		elif ub > lb:
    			re.append(str(lb) + '->' + str(ub))
    	return re

sol = Solution()
print sol.findMissingRanges([1, 2, 3, 50, 99], 0, 99)