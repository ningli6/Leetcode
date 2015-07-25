class Solution:
	# @param {character[][]} board
	# @return {boolean}
	def isValidSudoku(self, board):
		if not board or not board[0]:
			return False
		row = [[False for j in range(9)] for i in range(9)]
		col = [[False for j in range(9)] for i in range(9)]
		box = [[False for j in range(9)] for i in range(9)]
		for i in range(9):
			for j in range(9):
				if board[i][j] == '.':
					continue
				num = ord(board[i][j]) - '1'
				indexBox = self.findBox(i, j)
				if row[i][num] or col[j][num] or box[indexBox][num]:
					return False
				row[i][num], col[j][num], box[self.findBox(i, j)][num] = True, True, True
		return True

	def findBox(self, i, j):
		return 3 * (i / 3) + j / 3