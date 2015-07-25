class Solution:
	# @param {integer[]} nums
	# @return {integer}
	def removeDuplicates(self, nums):
		if not nums:
			return 0
		if len(nums) < 2:
			return len(nums)
		s, f = 0, 1
		while f < len(nums):
			if nums[f] != nums[s]:
				s += 1
				nums[s] = nums[f]
			f += 1
		return s + 1
