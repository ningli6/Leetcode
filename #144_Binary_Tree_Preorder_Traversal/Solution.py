'''
Recursive solution is trivial
'''

# Definition for a binary tree node.
class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.ans = None

	# @param {TreeNode} root
	# @return {integer[]}
	def preorderTraversal(self, root):
		self.ans = []
		self.preorder(root)
		return self.ans

	def preorder(self, root):
		if not root:
			return
		self.ans.append(root.val)
		self.preorder(root.left)
		self.preorder(root.right)