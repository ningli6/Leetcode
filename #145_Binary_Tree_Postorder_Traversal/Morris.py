class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	# @param {TreeNode} root
	# @return {integer[]}
	def postorderTraversal(self, root):
		if not root:
			return []
		re = []
		dummy = TreeNode(0)
		dummy.left = root
		cur = dummy
		while cur:
			rm = self.rightMostInLeftSubTree(cur)
			if rm is cur:         # no left child
				cur = cur.right   # go upwards
			elif rm.right is cur: # visited before
				rm.right = None   # break the link
				self.reverse(cur.left, rm) # reverse nodes
				tmp = rm
				while tmp is not cur.left:
					re.append(tmp.val)
					tmp = tmp.right
				re.append(cur.left.val)
				self.reverse(rm, cur.left) # reverse back
				cur = cur.right   # go right
			else:
				rm.right = cur    # build the link
				cur = cur.left    # go left
		return re

	# find the right most node in the left subtree
	# return itself if the node has no left child
	def rightMostInLeftSubTree(self, root):
		if not root or not root.left:  # if no more left subtree, return itself
			return root
		cur = root.left
		while cur.right:
			if cur.right is root: # avoid self loop
				break
			cur = cur.right
		return cur

	# reverse a sequence of tree node
	# endNode is guaranteed to be reached thru a right path from startNode
	def reverse(self, startNode, endNode):
		if not startNode or not endNode:
			return
		if startNode is endNode:
			return
		prev = startNode
		cur = startNode.right
		prev.right = None
		while prev is not endNode:
			tmp = cur.right
			cur.right = prev
			prev = cur
			cur = tmp