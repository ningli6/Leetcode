'''
Iterative solution with explicit stack
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
		stk = [root.left, root.right]
		while stk:
			lnd = stk.pop()
			rnd = stk.pop()
			if not lnd and not rnd:
				continue
			if not lnd or not rnd:
				return False
			if lnd.val != rnd.val:
				return False
			stk.append(lnd.left)
			stk.append(rnd.right)
			stk.append(lnd.right)
			stk.append(rnd.left)
		return True