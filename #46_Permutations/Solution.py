'''
Recursive approach
Do not need to use queue or set remove the element out,
Just swap it to the head of the list will do the job
'''

class Solution:
	# @param {integer[]} nums
	# @return {integer[][]}
	def permute(self, nums):
		if not nums:
			return []
		return self.findPermute(nums)

	# @param {integer[]} nums
	# @return {integer[][]}
	def findPermute(self, nums):
		if len(nums) == 1:
			return [[nums[0]]]
		result = []
		for x in range(len(nums)):
			self.swap(nums, 0, x)
			for comb in self.findPermute(nums[1:]):
				comb.append(nums[0])
				result.append(comb)
			self.swap(nums, 0, x)
		return result

	def swap(self, nums, i, j):
		if i == j:
			return
		tmp = nums[i]
		nums[i] = nums[j]
		nums[j] = tmp

sol = Solution()
print sol.permute([1, 2, 3])
