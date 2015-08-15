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
		startNode = None
		prev = None
		while cur:
			if cur.left or cur.right:
				if not startNode: # find start node of next level
					if cur.left:
						startNode = cur.left
					else:
						startNode = cur.right
				if cur.left:
					if not prev:
						prev = cur.left # if not yet have a prev node
					else:
						prev.next = cur.left
						prev = prev.next
				if cur.right:
					if not prev:
						prev = cur.right # if not yet have a prev node
					else:
						prev.next = cur.right
						prev = prev.next
			cur = cur.next
			if not cur:
				cur = startNode
				startNode = None
				prev = None