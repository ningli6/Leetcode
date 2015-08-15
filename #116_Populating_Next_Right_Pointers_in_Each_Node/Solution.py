# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
	# @param root, a tree link node
	# @return nothing
	def connect(self, root):
		if not root:
			return
		cur = root
		startNode = root
		while True:
			if cur is startNode:
				startNode = cur.left
				if not startNode:
					return
			cur.left.next = cur.right
			tmp = cur.right
			cur = cur.next
			if cur:
				tmp.next = cur.left
			else:
				cur = startNode