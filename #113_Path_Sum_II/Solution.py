class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @param {integer} sum
	# @return {integer[][]}
	def pathSum(self, root, sum):
		if not root:
			return []
		re = []
		self.addSum(root, sum, re, [])
		return re

	def addSum(self, root, sum, re, tmp):
		if not root:
			return
		if not root.left and not root.right and root.val == sum:
			re.append(tmp + [root.val]) # list + list
			return
		tmp.append(root.val)
		self.addSum(root.left, sum - root.val, re, tmp)
		self.addSum(root.right, sum - root.val, re, tmp)
		tmp.pop()

sol = Solution()
root = TreeNode(4)
print sol.pathSum(root, 5)