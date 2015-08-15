class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param head, a ListNode
	# @return a boolean
	def hasCycle(self, head):
		if not head:
			return False
		fast = head.next
		slow = head
		while fast and fast.next:
			if slow is fast:
				return True
			fast = fast.next.next
			slow = slow.next
		return False