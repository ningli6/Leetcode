class Solution:
	# @param {character[][]} board
	# @return {void} Do not return anything, modify board in-place instead.
	def solve(self, board):
		if not board or not board[0]:
			return
		for j in range(len(board[0])):
			if board[0][j] == '0':
				self.dfs(board, 0, j)
		for i in range(len(board)):
			if board[i][0] == '0':
				self.dfs(board, i, 0)
		for j in range(len(board[0])):
			if board[len(board) - 1][j] == '0':
				self.dfs(board, len(board) - 1, j)
		for i in range(len(board)):
			if board[i][len(board[0]) - 1] == '0':
				self.dfs(board, i, len(board[0]) - 1)
		for i in range(len(board)):
			for j in range(len(board[0])):
				if board[i][j] == 'Y':
					board[i][j] == '0'
				elif board[i][j] == '0':
					board[i][j] = 'X'

	def dfs(self, board, i, j):
		if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
			return
		if board[i][j] == 'X' or board[i][j] == 'Y':
			return
		if board[i][j] == '0':
			board[i][j] = 'Y'
		self.dfs(board, i - 1, j)
		self.dfs(board, i + 1, j)
		self.dfs(board, i, j - 1)
		self.dfs(board, i, j + 1)