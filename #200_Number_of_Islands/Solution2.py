class Solution(object):

	def __init__(self):
		self.count = 0
		self.visited = None
		self.rindex = None
		self.cindex = None

	def numIslands(self, grid):
		if not grid or not grid[0]:
			return 0
		self.count = 0
		self.visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
		self.rindex = []
		self.cindex = []
		for i in range(len(grid)):
			for j in range(len(grid[0])):
				if grid[i][j] == '0':
					continue
				if grid[i][j] == '1' and self.visited[i][j]:
					continue
				self.bfs(grid, i, j)
				self.count += 1
		return self.count

	def bfs(self, grid, i, j):
		self.rindex.append(i)
		self.cindex.append(j)
		while self.rindex:
			nodeI = self.rindex.pop()
			nodeJ = self.cindex.pop()
			self.visited[nodeI][nodeJ] = True
			if nodeI - 1 >= 0 and grid[nodeI - 1][nodeJ] == '1' and not self.visited[nodeI - 1][nodeJ]:
				self.rindex.append(nodeI - 1)
				self.cindex.append(nodeJ)
			if nodeI + 1 < len(grid) and grid[nodeI + 1][nodeJ] == '1' and not self.visited[nodeI + 1][nodeJ]:
				self.rindex.append(nodeI + 1)
				self.cindex.append(nodeJ)
			if nodeJ - 1 >= 0 and grid[nodeI][nodeJ - 1] == '1' and not self.visited[nodeI][nodeJ - 1]:
				self.rindex.append(nodeI)
				self.cindex.append(nodeJ - 1)
			if nodeJ + 1 < len(grid[0]) and grid[nodeI][nodeJ + 1] == '1' and not self.visited[nodeI][nodeJ + 1]:
				self.rindex.append(nodeI)
				self.cindex.append(nodeJ + 1)


sol = Solution()
t = [['1', '1', '0', '0', '0'], 
	['1', '1', '0', '0', '0'],
	['0', '0', '1', '0', '0'],
	['0', '0', '0', '1', '1']]
print sol.numIslands(t)