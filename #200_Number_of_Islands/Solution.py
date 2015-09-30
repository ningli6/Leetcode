class Solution(object):

	def __init__(self):
		self.count = 0
		self.visited = None

	def numIslands(self, grid):
		if not grid or not grid[0]:
			return 0
		self.count = 0
		self.visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
		for i in range(len(grid)):
			for j in range(len(grid[0])):
				if grid[i][j] == '0':
					continue
				if grid[i][j] == '1' and self.visited[i][j]:
					continue
				self.dfs(grid, i, j)
				self.count += 1
		return self.count

	def dfs(self, grid, i, j):
		if i < 0 or i >= len(grid):
			return
		if j < 0 or j >= len(grid[0]):
			return
		if self.visited[i][j] or grid[i][j] == '0':
			return
		self.visited[i][j] = True
		self.dfs(grid, i - 1, j)
		self.dfs(grid, i + 1, j)
		self.dfs(grid, i, j - 1)
		self.dfs(grid, i, j + 1)

sol = Solution()
t = [['1', '1', '0', '0', '0'], 
	['1', '1', '0', '0', '0'],
	['0', '0', '1', '0', '0'],
	['0', '0', '0', '1', '1']]
print sol.numIslands(t)