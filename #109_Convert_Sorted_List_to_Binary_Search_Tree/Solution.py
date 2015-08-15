'''
In order traversal solution
'''
class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	def __init__(self):
		self.cur = None

	# @param {ListNode} head
	# @return {TreeNode}
	def sortedListToBST(self, head):
		self.cur = head
		return self.build(self.countList(head))

	def build(self, n):
		if n < 1:
			return None
		root = TreeNode(0)
		root.left = self.build(n / 2)
		root.val = self.cur.val
		self.cur = self.cur.next
		root.right = self.build(n - n / 2 - 1)
		return root

	def countList(self, head):
		ans = 0
		cur = head
		while cur:
			ans += 1
			cur = cur.next
		return ans