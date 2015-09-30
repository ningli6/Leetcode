class Solution(object):

	def __init__(self):
		self.re = None

	def combinationSum3(self, k, n):
		"""
		:type k: int number of elements
		:type n: int target sum
		:rtype: List[List[int]]
		"""
		self.re = []
		if k <= 0 or k >= 10 or n < 1 or n > 45:
			return self.re
		nums = [x for x in range(1, 10)]
		self.combine(nums, 0, [], 0, k, n)
		return self.re

	def combine(self, nums, lv, tmp, sum, k, n):
		if lv == k and sum == n:
			self.re.append(list(tmp))
			return
		if not nums:
			return
		if lv < k and sum < n:
			for x in range(0, len(nums) - (k - lv - 1)):
				tmp.append(nums[x])
				self.combine(nums[x + 1:], lv + 1, tmp, sum + nums[x], k, n)
				tmp.pop()

sol = Solution()
print sol.combinationSum3(3, 15)