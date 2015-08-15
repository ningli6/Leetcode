'''
O(1) space
use first element for each row and col as indicator
matrix[0][0] is a special case
'''

class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def setZeroes(self, matrix):
        if not matrix or not matrix[0]:
        	return
        rows = len(matrix)
        cols = len(matrix[0])
        firstRow, firstCol = False, False
        for i in range(rows):
        	for j in range(cols):
        		if matrix[i][j] == 0:
        			matrix[i][0] = 0
        			matrix[0][j] = 0
        			if i == 0:
        				firstRow = True
        			if j == 0:
        				firstCol = True
        for i in range(1, rows):
        	if matrix[i][0] == 0:
        		for j in range(cols):
        			matrix[i][j] = 0
        for j in range(1, cols):
        	if matrix[0][j] == 0:
        		for i in range(rows):
        			matrix[i][j] = 0
        if firstCol:
        	for i in range(rows):
        		matrix[i][0] = 0
        if firstRow:
        	for j in range(cols):
        		matrix[0][j] = 0

sol = Solution()
t = [[1, 1, 1],
	[0, 1, 2]]
sol.setZeroes(t)
print t