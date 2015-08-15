'''
O(1) space using Morris traversal
'''

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {void} Do not return anything, modify root in-place instead.
	def recoverTree(self, root):
		badNode0, badNode1 = None, None
		prev, cur = None, root
		while cur:
			rm = self.findRightMostNode(cur) # make sure node is not None
			if not rm or rm.right is cur:
				if prev and prev.val > cur.val:
					if badNode0 is None:
						badNode0 = prev
						badNode1 = cur # tricky
					else:
						badNode1 = cur
				if rm:
					rm.right = None # break link
				prev = cur
				cur = cur.right
			else: # visit left
				rm.right = cur # build link
				cur = cur.left
		if badNode0 and badNode1:
			tmp = badNode0.val
			badNode0.val = badNode1.val
			badNode1.val = tmp

	# find the right most node in the left subtree
	def findRightMostNode(self, root):
		node = root.left
		while node and node.right:
			if node.right is root: # kill infinite loop
				break
			node = node.right
		return node

sol = Solution()
root = TreeNode(0)
root.left = TreeNode(1)
sol.recoverTree(root)