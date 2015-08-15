'''
Iterative solution, use explict stack
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {integer[]}
	def preorderTraversal(self, root):
		if not root:
			return []
		re = []
		stack = [root]
		node = root
		while stack or node:
			if node:
				re.append(node.val)
				node = node.left
			else:
				node = stack.pop().right
			if node:
				stack.append(node)
		return re