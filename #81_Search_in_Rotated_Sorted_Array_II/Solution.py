'''
Allow duplicates, it means nums[lo] <= nums[mid] doesn't guarantee left part is sorted! Same rule on the right side
eg. 1111115 -> 1151111
In this case the best we can do is O(n)
'''

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {boolean}
    def search(self, nums, target):
        if not nums:
        	return False
        lo, hi = 0, len(nums) - 1
        mid = lo + (hi - lo) / 2
        if nums[mid] == target:
        	return True
        if nums[mid] > nums[lo]: # left is sorted
        	if nums[lo] <= target and nums[mid] > target: # search left
	        	if self.search(nums[:mid], target):
	        		return True
	        else:
	        	if self.search(nums[mid + 1:], target): # otherwise search right
	        		return True
        elif nums[mid] < nums[hi]: # right is sorted
        	if nums[mid] < target and nums[hi] >= target:  # search right
        		if self.search(nums[mid + 1:], target):
        			return True
        	else:
        		if self.search(nums[:mid], target): # otherwise search left
        			return True
        else:
        	if nums[0] == target:
        		return True
        	return self.search(nums[1:], target)
        return False

sol = Solution()
t = [3, 1, 1]
print sol.search(t, 3)