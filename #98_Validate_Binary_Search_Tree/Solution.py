'''
in-order traversal
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.prev = None

	# @param {TreeNode} root
	# @return {boolean}
	def isValidBST(self, root):
		self.prev = None
		cur = root
		return self.inOrder(cur)

	def inOrder(self, root):
		if not root:
			return True
		if root.left:
			if not self.inOrder(root.left):
				return False
		if self.prev and root.val <= self.prev.val:
			return False
		self.prev = root# set prev for next level
		if root.right:
			if not self.inOrder(root.right):
				return False
		return True

sol = Solution()
root = TreeNode(1)
n1 = TreeNode(1)
# n2 = TreeNode(3)
root.left = n1
# root.right = n2
print sol.isValidBST(root)