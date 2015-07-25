class Solution:
	# @param {integer[][]} matrix
	# @return {integer[]}
	def spiralOrder(self, matrix):
		if not matrix:
			return []
		rowStart, colStart = 0, 0
		rowEnd, colEnd = len(matrix) - 1, len(matrix[0]) - 1
		re = []
		while rowStart <= rowEnd and colStart <= colEnd:
			for j in range(colStart, colEnd + 1):
				re.append(matrix[rowStart][j])
			rowStart += 1
			for i in range(rowStart, rowEnd + 1):
				re.append(matrix[i][colEnd])
			colEnd -= 1
			if rowStart <= rowEnd:
				for j in range(colEnd, colStart - 1, -1):
					re.append(matrix[rowEnd][j])
			rowEnd -= 1
			if colStart <= colEnd:
				for i in range(rowEnd, rowStart - 1, - 1):
					re.append(matrix[i][colStart])
			colStart += 1
		return re

sol = Solution()
t = [[2,5],[8,4],[0,-1]]
print sol.spiralOrder(t)