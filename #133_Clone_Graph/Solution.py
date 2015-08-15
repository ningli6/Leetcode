'''
Let's assume that no parallel edges

DFS solution
'''

# Definition for a undirected graph node
class UndirectedGraphNode:
	def __init__(self, x):
		self.label = x
		self.neighbors = []

class Solution:

	def __init__(self):
		self.dict = {};

	# @param node, a undirected graph node
	# @return a undirected graph node
	def cloneGraph(self, node):
		if not node:
			return node
		self.dict = {}
		return self.clone(node)

	def clone(self, node):
		newNode = UndirectedGraphNode(node.label)
		self.dict[node.label] = newNode
		for nd in node.neighbors:
			if nd is node:              # self-cycle
				newNode.neighbors.append(newNode)
			elif nd.label in self.dict: # already created
				newNode.neighbors.append(self.dict[nd.label])
			else:
				newNode.neighbors.append(self.clone(nd))
		return newNode

sol = Solution()
node0 = UndirectedGraphNode(0)
node1 = UndirectedGraphNode(1)
node2 = UndirectedGraphNode(2)
node0.neighbors = [node1, node2]
node1.neighbors = [node2]
node2.neighbors = [node2]
sol.cloneGraph(node0)