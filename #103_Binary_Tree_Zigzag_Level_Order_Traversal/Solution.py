'''
preorder traversal
'''

from collections import deque

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.ans = None

	# @param {TreeNode} root
	# @return {integer[][]}
	def zigzagLevelOrder(self, root):
		if not root:
			return []
		self.ans = []
		self.preOrder(root, 0)
		return self.ans

	def preOrder(self, root, level):
		if not root:
			return
		if len(self.ans) == level:
			self.ans.append(deque([root.val]))
		else:
			if level & 1:
				self.ans[level].appendleft(root.val)
			else:
				self.ans[level].append(root.val)
		self.preOrder(root.left, level + 1)
		self.preOrder(root.right, level + 1)

sol = Solution()
root = TreeNode(0)
nd1 = TreeNode(1)
nd2 = TreeNode(2)
nd3 = TreeNode(3)
nd4 = TreeNode(4)
root.left = nd1
root.right = nd2
nd1.left = nd3
nd2.left = nd4
print sol.zigzagLevelOrder(root)