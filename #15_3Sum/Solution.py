class Solution:
	# @param {integer[]} nums
	# @return {integer[][]}
	def threeSum(self, nums):
		if not nums or len(nums) < 3:
			return []
		re = []
		nums.sort()
		for x in range(0, len(nums) - 2):
			if x > 0 and nums[x] == nums[x - 1]:
				continue
			i = x + 1
			j = len(nums) - 1
			sum = 0 - nums[x]
			while i < j:
				if nums[i] + nums[j] > sum:
					j -= 1
					while i < j and nums[j] == nums[j + 1]:
						j -= 1
				elif nums[i] + nums[j] < sum:
					i += 1
					while i < j and nums[i] == nums[i - 1]:
						i += 1
				else:
					re.append([nums[x], nums[i], nums[j]])
					i += 1
					while i < j and nums[i] == nums[i - 1]:
						i += 1
					j -= 1
					while i < j and nums[j] == nums[j + 1]:
						j -= 1
		return re

sol = Solution()
s = [-2,0,1,1,2]
re = sol.threeSum(s)
for triple in re:
	for it in triple:
		print it,
	print