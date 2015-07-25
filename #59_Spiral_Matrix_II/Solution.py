class Solution:
	# @param {integer} n
	# @return {integer[][]}
	def generateMatrix(self, n):
		if n == 0:
			return []
		matrix = [[0 for j in range(n)] for i in range(n)]
		startRow = 0
		endRow = n - 1
		startCol = 0
		endCol = n - 1
		num = 1
		while startRow <= endRow:
			for j in range(startCol, endCol + 1):
				matrix[startRow][j] = num
				num += 1
			startRow += 1
			for i in range(startRow, endRow + 1):
				matrix[i][endCol] = num
				num += 1
			endCol -= 1
			for j in range(endCol, startCol - 1, -1):
				matrix[endRow][j] = num
				num += 1
			endRow -= 1
			for i in range(endRow, startRow - 1, -1):
				matrix[i][startCol] = num
				num += 1
			startCol += 1
		return matrix

sol = Solution()
print sol.generateMatrix(1)