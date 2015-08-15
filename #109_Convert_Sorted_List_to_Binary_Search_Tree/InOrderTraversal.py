'''
Inorder traversal using explict stack
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def inOrderTraversal(self, root):
		if not root:
			return []
		ans = []
		stack = []
		node = root
		while stack or node:
			if node:
				stack.append(node)
				node = node.left
			else:
				node = stack.pop()
				ans.append(node.val)
				node = node.right:
		return ans
