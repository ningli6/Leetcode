import sys

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer} the closest sum
    def threeSumClosest(self, nums, target):
        if not nums or len(nums) < 3:
        	return 0
        diff = sys.maxint
        ans = 0
        nums.sort()
        for x in range(len(nums) - 2):
        	if x > 0 and nums[x] == nums[x - 1]:
        		continue
        	sum = target - nums[x]
        	i = x + 1
        	j = len(nums) - 1
        	while i < j:
        		if nums[i] + nums[j] > sum:
        			if abs(nums[i] + nums[j] - sum) < diff:
        				ans = nums[x] + nums[i] + nums[j]
        				diff = abs(nums[i] + nums[j] - sum)
        			j -= 1
        		elif nums[i] + nums[j] < sum:
        			if abs(nums[i] + nums[j] - sum) < diff:
        				ans = nums[x] + nums[i] + nums[j]
        				diff = abs(nums[i] + nums[j] - sum)
        			i += 1
        		else:
        			return nums[x] + nums[i] + nums[j]
        return ans

sol = Solution()
s = [0,2,1,-3]
print sol.threeSumClosest(s, 1)