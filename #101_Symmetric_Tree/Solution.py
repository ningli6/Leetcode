'''
Level order traversal won't work!
Recursive solution
'''
class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {boolean}
	def isSymmetric(self, root):
		if not root:
			return True
		return self.sameTree(root.left, root.right)

	def sameTree(self, lnd, rnd):
		if not lnd and not rnd:
			return True
		if not lnd or not rnd:
			return False
		if lnd.val != rnd.val:
			return False
		return self.sameTree(lnd.left, rnd.right) and self.sameTree(lnd.right, rnd.left)