'''
O(n) time, O(n) space, 3 pass solution
'''

class Solution:
    # @param {integer[]} height
    # @return {integer}
    def trap(self, height):
        if not height or len(height) < 3:
        	return 0
        left = [0 for x in range(len(height))]
        right = [0 for x in range(len(height))]
        maxHeight = 0
        for i in range(1, len(height)):
        	left[i] = max(height[i - 1], maxHeight)
        	maxHeight = left[i]
        maxHeight = 0
        for i in range(len(height) - 2, -1, -1):
        	right[i] = max(height[i + 1], maxHeight)
        	maxHeight = right[i]
        ans = 0
        for i in range(len(height)):
        	ans += max(0, min(left[i], right[i]) - height[i])
        return ans

sol = Solution()
print sol.trap([0,1,0,2,1,0,1,3,2,1,2,1])
