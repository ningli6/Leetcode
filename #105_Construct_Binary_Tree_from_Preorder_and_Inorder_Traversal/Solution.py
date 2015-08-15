class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.map = None

	# @param {integer[]} preorder
	# @param {integer[]} inorder
	# @return {TreeNode}
	def buildTree(self, preorder, inorder):
		if not preorder or not inorder:
			return None
		self.map = {}
		for index, value in enumerate(inorder):
			self.map[value] = index
		return self.build(preorder, inorder, 0, len(inorder) - 1)

	def build(self, preorder, inorder, start, end):
		if not preorder or start > end:
			return None
		root = TreeNode(preorder[0])
		index = self.map[preorder[0]]
		leftElements = index - start
		root.left = self.build(preorder[1:1 + leftElements], inorder, start, index - 1)
		root.right = self.build(preorder[1 + leftElements:], inorder, index + 1, end)
		return root