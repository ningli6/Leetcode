class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @param {integer} k
	# @return {ListNode}
	def reverseKGroup(self, head, k):
		if k < 2:
			return head
		dummy = ListNode(-1)
		dummy.next = head
		p = dummy
		while p:
			p = self.reverseList(p, k)
		return dummy.next

	def reverseList(self, prev, k):
		end = prev
		for x in range(k):
			end = end.next
			if not end:
				return None
		start = prev.next
		p = start
		c = p.next
		start.next = end.next
		prev.next = end
		while p is not end:
			n = c.next
			c.next = p
			p = c
			c = n
		return start



