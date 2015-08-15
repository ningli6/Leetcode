'''
Morris solution
O(1) space
'''
class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {TreeNode} root
	# @return {integer[]}
	def inorderTraversal(self, root):
		if not root:
			return []
		re = []
		node = root
		while node:
			rm = self.findSubRightMost(node)
			if not rm: # leaf node
				re.append(node.val)# append before go right
				node = node.right
			elif rm.right is node: # vistied once
				rm.right = None    # break link
				re.append(node.val)# append before go right
				node = node.right
			else: # not visited
				rm.right = node    # build link
				node = node.left
		return re

    # Find the right most node in the left subtree
	def findSubRightMost(self, root):
		node = root.left
		while node and node.right:
			if node.right is root: # if next right is root itself, loop exists, break
				return node
			node = node.right
		return node

sol = Solution()
node0 = TreeNode(0)
n1 = TreeNode(1)
n2 = TreeNode(2)
node0.left = n1
node0.right = n2
print sol.inorderTraversal(node0)