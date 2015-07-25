class Solution:
	# @param {integer[]} nums
	# @return {integer[][]}
	def permuteUnique(self, nums):
		if not nums:
			return []
		if len(nums) < 2:
			return [[nums[0]]]
		result = []
		hset = set()
		for x in range(len(nums)):
			if nums[x] in hset:
				continue
			hset.add(nums[x])
			self.swap(nums, 0, x)
			for comb in self.permuteUnique(nums[1:]):
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
print sol.permuteUnique([1, 2, 1])