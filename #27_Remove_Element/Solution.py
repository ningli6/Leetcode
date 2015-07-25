class Solution:
	# @param {integer[]} nums
	# @param {integer} val
	# @return {integer}
	def removeElement(self, nums, val):
		if not nums:
			return 0
		s, f = 0, 0
		while f < len(nums):
			if nums[f] != val:
				nums[s] = nums[f]
				s += 1
			f += 1
		return s