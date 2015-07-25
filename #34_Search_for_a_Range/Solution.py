class Solution:
	# @param {integer[]} nums
	# @param {integer} target
	# @return {integer[]}
	def searchRange(self, nums, target):
		if not nums:
			return [-1, -1]
		i, j, mid = 0, len(nums) - 1, 0
		while i <= j:
			mid = i + (j - i) / 2
			if nums[mid] == target:
				break
			elif nums[mid] > target:
				j = mid - 1
			else:
				i = mid + 1
		if i > j:
			return [-1, -1]
		return [self.searchLeft(nums, target, i, mid), self.searchRight(nums, target, mid, j)]

	# hi always remains possible result
	def searchLeft(self, nums, target, lo, hi):
		if lo == hi:
			return lo
		mid = lo + (hi - lo) / 2
		if nums[mid] == target:
			return self.searchLeft(nums, target, lo, mid)
		return self.searchLeft(nums, target, mid + 1, hi)

	# lo always remains possible result
	def searchRight(self, nums, target, lo, hi):
		if lo == hi:
			return lo
		mid = lo + (hi - lo) / 2
		if mid == lo: # special case for right search,
			mid += 1
		if nums[mid] == target:
			return self.searchRight(nums, target, mid, hi)
		return self.searchRight(nums, target, lo, mid - 1)

sol = Solution()
t = [5, 7, 7, 8, 8, 10]
print sol.searchRange(t, 8)

