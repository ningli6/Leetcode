class Solution:

	def __init__(self):
		self.cols = None
		self.back = None
		self.forward = None
		self.board = None
		self.ans = None
		self.size = None

	# @param {integer} n
	# @return {string[][]}
	def solveNQueens(self, n):
		if n == 1:
			return [['Q']]
		if n < 4:
			return []
		self.size = n
		self.cols = [False for x in range(n)]
		self.back = [False for x in range(2 * n - 1)]
		self.forward = [False for x in range(2 * n - 1)]
		self.board = [['.' for j in range(n)] for i in range(n)]
		self.ans = []
		self.backtrace(0)
		return self.ans

	def backtrace(self, i):
		if i == self.size:
			self.findBoard()
			return
		for j in range(self.size):
			if not self.isValid(i, j):
				continue
			self.put(i, j, True)
			self.backtrace(i + 1)
			self.put(i, j, False)

	def put(self, i, j, setup):
		if setup:
			self.board[i][j] = 'Q'
			self.cols[j] = True
			self.back[self.backIndex(i, j)] = True
			self.forward[self.forwardIndex(i, j)] = True
		else:
			self.board[i][j] = '.'
			self.cols[j] = False
			self.back[self.backIndex(i, j)] = False
			self.forward[self.forwardIndex(i, j)] = False

	def findBoard(self):
		self.ans.append([''.join(self.board[x]) for x in range(self.size)])

	def isValid(self, i, j):
		return not self.cols[j] and not self.back[self.backIndex(i, j)] and not self.forward[self.forwardIndex(i, j)]

	def backIndex(self, i, j):
		return j - i + (self.size - 1)

	def forwardIndex(self, i, j):
		return i + j

sol = Solution()
print sol.solveNQueens(4)