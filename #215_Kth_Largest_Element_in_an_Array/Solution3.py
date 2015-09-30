'''
Quick select solution
time: O(n) probablistic guaranteed
space: O(1)
'''

import random

class Solution(object):

	def findKthLargest(self, nums, k):
		"""
		:type nums: List[int]
		:type k: int
		:rtype: int
		"""
		if k <= 0 or k > len(nums):
			return
		k = len(nums) - k
		self.shuffle(nums)
		lo, hi = 0, len(nums) - 1
		while True:
			j = self.partition(nums, lo, hi)
			if j == k:
				return nums[j]
			if j > k:
				hi = j - 1
			else:
				lo = j + 1

	# make nums[s] in place
	def partition(self, nums, s, e):
		lo, hi = s + 1, e
		while True:
			while lo < hi and nums[lo] < nums[s]:
				lo += 1
			while nums[hi] > nums[s]:
				hi -= 1
			if lo >= hi:
				break
			self.exchange(nums, lo, hi)
			lo += 1
			hi -= 1
		self.exchange(nums, s, hi)
		return hi

	# Fisher-Yates shuffle
	# time: O(n), space: O(1)
	def shuffle(self, nums):
		if not nums or len(nums) == 1:
			return
		for x in range(len(nums) - 1, 0, -1):
			r = random.randint(0, x)
			self.exchange(nums, r, x)
		return nums

	def exchange(self, nums, i, j):
		if i < 0 or i >= len(nums):
			raise IndexError('list index out of range')
		if j < 0 or j >= len(nums):
			raise IndexError('list index out of range')
		if i == j:
			return
		tmp = nums[i]
		nums[i] = nums[j]
		nums[j] = tmp

sol = Solution()
a = [1, 3, 4 ,2 ,5]
# print sol.partition(a, 1, 4), a
print sol.findKthLargest(a, 5)