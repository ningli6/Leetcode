class Solution(object):
    def summaryRanges(self, nums):
        re = []
        if not nums:
        	return re
        i = 0
        while i < len(nums):
        	j = i
        	while j + 1 < len(nums) and nums[j + 1] == nums[j] + 1:
        		j += 1
        	re.append(self.generateRange(nums[i], nums[j]))
        	i = j + 1
        return re

    def generateRange(self, a, b):
    	if a == b:
    		return str(a)
    	return str(a) + "->" + str(b)

sol = Solution()
print sol.summaryRanges([0,1,2,4,5,7])