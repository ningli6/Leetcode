'''
O(n) Solution
Use two edge arrays to find out left and right edge for each height value
Use stack to help create edge array

improve:
don't need to find right edge, as long as current index is lower than its left height, it is right edge then
'''

class Solution:
    # @param {integer[]} height
    # @return {integer}
    def largestRectangleArea(self, height):
        if not height:
        	return 0
        left = [0 for x in range(len(height))]
        right = [0 for x in range(len(height))]
        stk = []
        for x in range(len(height)):
        	while stk:
        		if height[x] > height[stk[len(stk) - 1]]: # watch for equal case
        			left[x] = stk[len(stk) - 1]
        			stk.append(x)
        			break
        		else:
        			stk.pop()
        	if not stk:
        		left[x] = -1
        		stk.append(x)
        stk = []
        for x in range(len(height) - 1, -1, -1):
        	while stk:
        		if height[x] > height[stk[len(stk) - 1]]: # watch for equal case
        			right[x] = stk[len(stk) - 1]
        			stk.append(x)
        			break
        		else:
        			stk.pop()
        	if not stk:
        		right[x] = len(height)  # right side should be len(height)
        		stk.append(x)
        ans = 0
        for x in range(len(height)):
        	ans = max(ans, height[x] * (right[x] - left[x] - 1))
        return ans

sol = Solution()
print sol.largestRectangleArea([1, 1])