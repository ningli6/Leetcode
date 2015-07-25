'''
Problems:
1. return index, so must keep the full array
2. after rotation, at least half of the array will remain sorted
3. constraint of i, j, deal with lo == hi, lo == mid while lo != hi
'''

class Solution:
	# @param {integer[]} nums
	# @param {integer} target
	# @return {integer}
	def search(self, nums, target):
		return self.searchInRange(nums, target, 0, len(nums) - 1)

	def searchInRange(self, nums, target, lo, hi):
		if not nums or lo < 0 or hi >= len(nums) or lo > hi:
			return -1
		mid = lo + (hi - lo) / 2 # avoid overflow
		if nums[mid] == target:
			return mid
		if lo == hi:
			return -1
		if mid == lo:
			return self.searchInRange(nums, target, mid + 1, hi)
		# if mid == hi:
		# 	return self.searchInRange(nums, target, lo, mid - 1)
		if nums[mid] > nums[lo]: # left part is sorted
			if nums[lo] <= target and target <= nums[mid - 1]:
				return self.searchInRange(nums, target, lo, mid - 1)
			return self.searchInRange(nums, target, mid + 1, hi)
		if nums[mid] < nums[hi]: # right part is sorted
			if nums[mid + 1] <= target and target <= nums[hi]:
				return self.searchInRange(nums, target, mid + 1, hi)
			return self.searchInRange(nums, target, lo, mid - 1)

sol = Solution()
t = [3, 1]
print sol.search(t, 1)