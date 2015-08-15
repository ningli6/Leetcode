'''
O(m * n) Solution

for each row, find the maximum rectangle area
'''

class Solution:
    # @param {character[][]} matrix
    # @return {integer}
    def maximalRectangle(self, matrix):
        if not matrix or not matrix[0]:
            return 0
        height = [0 for j in range(len(matrix[0]))]
        ans = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == '0':
                    height[j] = 0
                else:
                    height[j] += 1
            ans = max(ans, self.largestRectangleArea(height))
        return ans

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
t = [['1', '0', '1'], ['1', '1', '1'], ['1', '1', '1']]
print sol.maximalRectangle(t)