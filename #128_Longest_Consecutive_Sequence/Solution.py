import sys

class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def longestConsecutive(self, nums):
        if not nums:
        	return 0
        map = {}
        for n in nums:
        	if not n in map:
        		left = map.get(n - 1, 0)
        		right = map.get(n + 1, 0)
        		map[n] = left + right + 1             # update itself in case it's an edge
        		if n - 1 in map:
        			map[n - left] = left + right + 1  # update left bounds
        		if n + 1 in map:
        			map[n + right] = left + right + 1 # update right bounds
        re = 0
        for n in nums:
        	re = max(re, map[n])
        return re

sol = Solution()
print sol.longestConsecutive([5, 6, 7, 8, 4])