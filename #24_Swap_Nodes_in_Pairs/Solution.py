class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @return {ListNode}
	def swapPairs(self, head):
		dummy = ListNode(-1)
		dummy.next = head
		p = dummy
		c = head
		while c and c.next:
			n = c.next
			p.next = n
			c.next = n.next
			n.next = c
			c = c.next
			p = p.next.next
		return dummy.next