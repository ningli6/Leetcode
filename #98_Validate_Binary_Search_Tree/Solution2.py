'''
For each node, check if it is within a certain range
'''

import sys

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	# @param {TreeNode} root
	# @return {boolean}
	def isValidBST(self, root):
		return self.isValid(root, -sys.maxint - 1, sys.maxint)

	def isValid(self, root, minVal, maxVal):
		if not root:
			return True
		if root.val <= minVal or root.val >= maxVal:
			return False
		return self.isValid(root.left, minVal, root.val) and self.isValid(root.right, root.val, maxVal)