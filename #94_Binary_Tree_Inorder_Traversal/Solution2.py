'''
Iterative approach with explict stack
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	# @param {TreeNode} root
	# @return {integer[]}
	def inorderTraversal(self, root):
		if not root:
			return []
		re = []
		stk = []
		node = root # root node for each stack level
		while stk or node:
			if node:
				stk.append(node)
				node = node.left
			else:
				node = stk.pop()
				re.append(node.val)
				node = node.right
		return re