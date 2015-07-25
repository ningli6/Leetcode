class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def jump(self, nums):
        if not nums or len(nums) < 2:
        	return 0
        if len(nums) == 2:
        	return 1
        step = 0
        maxIndex = 0
        cur = 0
        while maxIndex < len(nums) - 1:
        	tmp = maxIndex
        	while cur <= tmp:
        		maxIndex = max(maxIndex, cur + nums[cur])
        		cur += 1
        	step += 1
        return step

sol = Solution()
print sol.jump([2,3,1,1,4])