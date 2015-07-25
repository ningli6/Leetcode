'''
Use a hashtable, time O(n), space O(n)
'''
class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, nums, target):
    	map = {}
    	for i, val in enumerate(nums):
    		if (target - val in map):
    			return map[target - val] + 1, i + 1
    		map[val] = i
    	return -1, -1

nums = [3, 2, 4]
sol = Solution()
print sol.twoSum(nums, 6)

