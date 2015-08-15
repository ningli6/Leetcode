'''
Recursive Solution
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
	def postorderTraversal(self, root):
		self.re = []
		self.postorder(root)
		return self.re

	def postorder(self, root):
		if not root:
			return
		self.postorder(root.left)
		self.postorder(root.right)
		self.re.append(root.val)