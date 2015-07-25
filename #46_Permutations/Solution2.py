'''
Iterative approach
This is a less appropriate approach
'''

from collections import deque

class Solution:
	# @param {integer[]} nums
	# @return {integer[][]}
	def permute(self, nums):
		if not nums:
			return 0
		queue = deque()
		queue.append([nums[0]])
		for x in range(1, len(nums)):
			while len(queue[0]) <= x:
				val = queue.popleft()
				for y in range(0, len(val) + 1):
					cp = list(val)
					cp.insert(y, nums[x])
					queue.append(cp)
			if len(queue[0]) == len(nums):
				return queue

sol = Solution()
print sol.permute([1, 2, 3])
