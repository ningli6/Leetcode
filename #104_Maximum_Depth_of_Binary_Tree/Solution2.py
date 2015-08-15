'''
use level order queue to avoid stack overflow
'''

from collections import deque

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {integer}
	def maxDepth(self, root):
		if not root:
			return 0
		lv = 0
		queue = deque()
		queue.append(root)
		while queue:
			lv += 1
			for x in range(len(queue)):
				nd = queue.popleft()
				if nd.left:
					queue.append(nd.left)
				if nd.right:
					queue.append(nd.right)
		return lv