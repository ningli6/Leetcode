class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
        	return 0
        i, j = 0, 0
        sum = 0
        minLen = len(nums) + 1
        while True:
        	if sum < s:
        		if j >= len(nums):
        			break
        		sum += nums[j]
        		j += 1
        	if sum >= s:
        		minLen = min(minLen, j - i)
        		sum -= nums[i]
        		i += 1
        if minLen == len(nums) + 1:
        	return 0
        return minLen

sol = Solution()
print sol.minSubArrayLen(7, [2,3,1,2,4,3])