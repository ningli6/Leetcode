# Definition for a binary tree node.
class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {TreeNode}
	def upsideDownBinaryTree(self, root):
		if not root or not root.left:
			return root
		newRoot = self.upsideDownBinaryTree(root.left)
		root.left.left = root.right
		root.left.right = root
		root.left = None
		root.right = None
		return newRoot