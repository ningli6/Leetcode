class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @param {integer} n
	# @return {ListNode}
	def removeNthFromEnd(self, head, n):
		if not head or n < 1:
			return head
		dummy = ListNode(-1)
		dummy.next = head
		pre, cur, fast = dummy, head, head
		for i in range(n):
			if not fast:
				return head
			fast = fast.next
		while fast:
			pre, cur, fast = pre.next, cur.next, fast.next
		pre.next, cur.next = cur.next, None
		return dummy.next