'''
Based on 3 sum and 2 sum, O(n^3) solution
'''

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[][]}
    def fourSum(self, nums, target):
        if not nums or len(nums) < 4:
        	return []
        re = []
        nums.sort()
        for x in range(len(nums) - 3):
        	if x > 0 and nums[x] == nums[x - 1]:
        		continue
        	threeSum = target - nums[x]
        	for y in range(x + 1, len(nums) - 2):
        		if y > x + 1 and nums[y] == nums[y - 1]:
        			continue
        		twoSum = threeSum - nums[y]
        		i = y + 1
        		j = len(nums) - 1
        		while i < j:
        			if nums[i] + nums[j] > twoSum:
        				j -= 1
        			elif nums[i] + nums[j] < twoSum:
        				i += 1
        			else:
        				re.append([nums[x], nums[y], nums[i], nums[j]])
        				i += 1
        				j -= 1
        				while i > y + 1 and i < j and nums[i] == nums[i - 1]:
        					i += 1
        				while j < len(nums) - 2 and i < j and nums[j] == nums[j + 1]:
        					j -= 1
        return re

sol = Solution()
t = [1, 0, -1, 0, -2, 2]
re = sol.fourSum(t, 0)
for entry in re:
	for ele in entry:
		print ele,
	print