class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {integer[]}
	def preorderTraversal(self, root):
		if not root:
			return []
		re = []
		cur = root
		while cur:
			re.append(cur.val)
			rm = self.rightMostInLeftSubTree(cur)
			if rm is cur:          # no more left child
				cur = cur.right    # go back to its parent
			elif rm.right is cur:  # visited before
				re.pop()
				cur = cur.right    # go right
				rm.right = None    # break the link
			else:
				rm.right = cur     # build the link
				cur = cur.left     # go left
		return re


	def rightMostInLeftSubTree(self, root):
		if not root or not root.left:  # if no more left subtree, return itself
			return root
		cur = root.left
		while cur.right:
			if cur.right is root: # avoid self loop
				break
			cur = cur.right
		return cur