class Solution:
	# @param {character[][]} board
	# @return {void} Do not return anything, modify board in-place instead.
	def solveSudoku(self, board):
		if not board or not board[0]:
			return
		row = [[False for j in range(9)] for i in range(9)]
		col = [[False for j in range(9)] for i in range(9)]
		box = [[False for j in range(9)] for i in range(9)]
		for i in range(9):
			for j in range(9):
				if board[i][j] == '.':
					continue
				num = ord(board[i][j]) - ord('1')
				bindex = self.findBox(i, j)
				if row[i][num] or col[j][num] or box[bindex][num]:
					return
				row[i][num], col[j][num], box[bindex][num] = True, True, True
		self.backTrace(board, 0, 0, row, col, box)

	def backTrace(self, board, i, j, row, col, box):
		if j == 9:
			i += 1
			j = 0
		while i < 9 and j < 9 and board[i][j] != '.':
			j += 1
			if j == 9:
				i += 1
				j = 0
		if i == 9:
			return True
		for x in range(1, 10):
			num = x - 1
			bindex = self.findBox(i, j)
			if row[i][num] or col[j][num] or box[bindex][num]:
				continue
			board[i][j] = chr(ord('1') + num)
			row[i][num], col[j][num], box[bindex][num] = True, True, True
			if self.backTrace(board, i, j + 1, row, col ,box):
				return True
			board[i][j] = '.'
			row[i][num], col[j][num], box[bindex][num] = False, False, False
		return False

	def findBox(self, i, j):
		return 3 * (i / 3) + j / 3

sol = Solution()
test = [
	['5', '3', '.', '.', '7', '.', '.', '.', '.'],
	['6', '.', '.', '1', '9', '5', '.', '.', '.'],
	['.', '9', '8', '.', '.', '.', '.', '6', '.'],
	['8', '.', '.', '.', '6', '.', '.', '.', '3'],
	['4', '.', '.', '8', '.', '3', '.', '.', '1'],
	['7', '.', '.', '.', '2', '.', '.', '.', '6'],
	['.', '6', '.', '.', '.', '.', '2', '8', '.'],
	['.', '.', '.', '4', '1', '9', '.', '.', '5'],
	['.', '.', '.', '.', '8', '.', '.', '7', '9']]
sol.solveSudoku(test)
print test