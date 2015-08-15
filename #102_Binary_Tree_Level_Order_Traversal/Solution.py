'''
bfs
'''

from collections import deque

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {integer[][]}
	def levelOrder(self, root):
		if not root:
			return []
		re = [[root.val]]
		cur, next = 1, 0
		queue = deque([root])
		while queue:
			nd = queue.popleft()
			cur -= 1
			if nd.left:
				queue.append(nd.left)
				next += 1
			if nd.right:
				queue.append(nd.right)
				next += 1
			if cur == 0 and queue: # avoid empty
				re.append([node.val for node in queue])
				cur = next
				next = 0
		return re

sol = Solution()
root = TreeNode(0)
nd1 = TreeNode(1)
nd2 = TreeNode(2)
nd3 = TreeNode(3)
nd4 = TreeNode(4)
root.left = nd1
root.right = nd2
nd1.left = nd3
nd2.left = nd4
print sol.levelOrder(root)