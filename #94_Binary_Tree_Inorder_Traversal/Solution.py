'''
Recursive approach
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.re = None

	# @param {TreeNode} root
	# @return {integer[]}
	def inorderTraversal(self, root):
		self.re = []
		self.traversal(root)
		return self.re

	def traversal(self, root):
		if not root:
			return
		if root.left:
			self.traversal(root.left)
		self.re.append(root.val)
		if root.right:
			self.traversal(root.right)