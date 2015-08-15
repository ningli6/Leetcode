class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.maxLv = 0

	# @param {TreeNode} root
	# @return {integer}
	def maxDepth(self, root):
		if not root:
			return 0
		self.maxLv = 0
		self.findDepth(root, 0)
		return self.maxLv + 1

	def findDepth(self, root, level):
		if not root:
			return
		self.maxLv = max(level, self.maxLv)
		self.findDepth(root.left, level + 1)
		self.findDepth(root.right, level + 1)