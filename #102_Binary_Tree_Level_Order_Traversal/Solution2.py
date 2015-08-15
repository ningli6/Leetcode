'''
Preorder traversal
dfs
'''

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
	def levelOrder(self, root):
		if not root:
			return []
		self.ans = []
		self.traverse(root, 0)
		return self.ans

	def traverse(self, root, level):
		if not root:
			return
		if level == len(self.ans):
			self.ans.append([root.val])
		else:
			self.ans[level].append(root.val)
		self.traverse(root.left, level + 1)
		self.traverse(root.right, level + 1)

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
print sol.levelOrder(root)