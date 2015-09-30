'''
Given a directed graph, find if the graph contains circle
For directed graph, don't need to explicitly handle the case of self loop and parallel edge
'''

class Solution(object):

	def __init__(self):
		self.isVisited = None
		self.onPath = None
		self.adj = None
		self.hasCycle = False

	def canFinish(self, numCourses, prerequisites):
		if not numCourses:
			return True
		self.isVisited = [False for x in range(numCourses)]
		self.onPath = [False for x in range(numCourses)]
		self.adj = [[] for x in range(numCourses)]
		for pre in prerequisites:
			self.adj[pre[1]].append(pre[0])
		for x in range(numCourses):
			if not self.hasCycle and not self.isVisited[x]:
				self.dfs(x)
		return not self.hasCycle

	def dfs(self, v):
		self.isVisited[v] = True
		self.onPath[v] = True
		for w in self.adj[v]:
			if not self.isVisited[w]:
				self.dfs(w)
			elif self.onPath[w]:
				self.hasCycle = True
				return
		self.onPath[v] = False

sol = Solution()
print sol.canFinish(2, [[1, 0], [0, 1]])