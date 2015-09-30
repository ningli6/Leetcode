'''
Use priority queue (heap based)
time: O(n * log(k))
space: O(k)

Problem: how to get size of pq
'''

import Queue as Q

class Solution(object):

	def findKthLargest(self, nums, k):
		"""
		:type nums: List[int]
		:type k: int
		:rtype: int
		"""
		pq = Q.PriorityQueue()
		for n in nums:
			pq.put(n)
			if pq.qsize() > k:
				pq.get()
		return pq.get()

sol = Solution()
print sol.findKthLargest([1, 2, 3, 4], 4)