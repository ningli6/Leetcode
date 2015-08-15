'''
Iterative approach
explicit stack
'''
class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	# @param {TreeNode} root
	# @return {void} Do not return anything, modify root in-place instead.
	def flatten(self, root):
		if not root:
			return
		cur = root
		stack = []
		while stack: