class Solution(object):

	def canFinish(self, numCourses, prerequisites):
		if not numCourses:
			return True
		adj = [[] for x in range(numCourses)]
		inComing = [0 for x in range(numCourses)]
		for pre in prerequisites:
			adj[pre[1]].append(pre[0])
			inComing[pre[0]] += 1
		s = set()
		for x in range(numCourses):
			if inComing[x] == 0:
				s.add(x)
		while s:
			v = s.pop()
			for w in adj[v]:
				inComing[w] -= 1
				if inComing[w] == 0:
					s.add(w)
		for ind in inComing:
			if ind > 0:
				return False
		return True

sol = Solution()
print sol.canFinish(2, [[1, 0]])