class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.sum = 0

	# @param {TreeNode} root
	# @return {integer}
	def sumNumbers(self, root):
		self.sum = 0
		self.dfs(root, 0)
		return self.sum

	def dfs(self, root, pathSum):
		if not root:
			return
		if not root.left and not root.right:
			self.sum += pathSum * 10 + root.val
			return
		self.dfs(root.left, pathSum * 10 + root.val)
		self.dfs(root.right, pathSum * 10 + root.val)

sol = Solution()
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
print sol.sumNumbers(root)