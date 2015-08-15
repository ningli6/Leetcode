'''
Recursive pre-order Solution
takes advantage of the fact that flattened tree are actually in pre-order
Takes time O(n)
sapce O(log(n))
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.cur = None

	# @param {TreeNode} root
	# @return {void} Do not return anything, modify root in-place instead.
	def flatten(self, root):
		if not root:
			return
		self.cur = root
		self.flatten(root.left)
		self.cur.right = root.right
		if root.left:
			root.right = root.left
		root.left = None
		self.flatten(self.cur.right)


sol = Solution()
root = TreeNode(0)
n1 = TreeNode(1)
root.left = n1
sol.flatten(root)