'''
BFS for topological sort
'''

class Solution(object):
	def findOrder(self, numCourses, prerequisites):
		"""
		:type numCourses: int
		:type prerequisites: List[List[int]]
		:rtype: List[int]
		"""
		if numCourses <= 0:
			return []
		zeroInDegree = set()
		topo = []
		adj = [[] for x in range(numCourses)]
		inDegree = [0 for x in range(numCourses)]
		for pre in prerequisites:
			adj[pre[1]].append(pre[0])
			inDegree[pre[0]] += 1
		for x in range(numCourses):
			if inDegree[x] == 0:
				zeroInDegree.add(x)
		while zeroInDegree:
			v = zeroInDegree.pop()
			topo.append(v)
			for w in adj[v]:
				inDegree[w] -= 1
				if inDegree[w] == 0:
					zeroInDegree.add(w)
		for x in range(numCourses):
			if inDegree[x] > 0:
				return []
		return topo