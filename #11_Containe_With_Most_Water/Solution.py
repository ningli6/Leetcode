class Solution:
    # @param {integer[]} height
    # @return {integer}
    def maxArea(self, height):
        if not height:
        	return 0
        re = 0
        i, j = 0, len(height) - 1
        while i < j:
        	re = max(re, (j - i) * min(height[i], height[j]))
        	if height[i] <= height[j]:
        		i += 1
        	elif height[i] >= height[j]:
        		j -= 1
        	else:
        		i += 1
        		j -= 1
        return re


sol = Solution()
t = [3, 7, 9, 2]
print sol.maxArea(t)