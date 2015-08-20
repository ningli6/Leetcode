class Solution(object):
    def rob(self, nums):
    	if not nums:
    		return 0
    	rob, skip = 0, 0
    	for val in nums:
    		tmp = rob
    		rob = val + skip
    		skip = max(skip, tmp)
    	return max(rob, skip)

sol = Solution()
print sol.rob([1, 2, 3])