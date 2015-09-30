from collections import deque

class Solution(object):
    def maxSlidingWindow(self, nums, k):
    	if not nums or k <= 1:
    		return nums
    	re = [0 for x in range(len(nums) - k + 1)]
    	queue = deque()
    	for x in range(len(nums)):
    		if queue and queue[0] < x - k + 1:
    			queue.popleft()
    		while queue and nums[queue[len(queue) - 1]] <= nums[x]:
    			queue.pop()
    		queue.append(x)
    		if x >= k - 1:
    			re[x - k + 1] = nums[queue[0]]
    	return re

sol = Solution()
print sol.maxSlidingWindow([7, 2, 4], 2)