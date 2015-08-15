class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {boolean}
	def isBalanced(self, root):
		return self.depth(root) >= 0

	def depth(self, root):
		if not root:
			return 0
		ld = self.depth(root.left)
		rd = self.depth(root.right)
		if ld == -1 or rd == -1: # -1 need to be pass on
			return -1
		if abs(ld - rd) > 1: # check depth diff
			return -1
		return max(ld, rd) + 1