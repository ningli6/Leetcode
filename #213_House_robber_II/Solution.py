class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
        	return 0
        if len(nums) == 1:
        	return nums[0]
        return max(self.subRob(nums[:len(nums) - 1]), self.subRob(nums[1:]))

    def subRob(self, nums):
    	if not nums:
    		return 0
    	rob, skip = 0, 0
    	for val in nums:
    		tmp = rob
    		rob = val + skip
    		skip = max(skip, tmp)
    	return max(rob, skip)

sol = Solution()
print sol.rob([1, 1])