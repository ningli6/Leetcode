class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @return {ListNode}
	def deleteDuplicates(self, head):
		cur = head
		while cur and cur.next:
			if cur.val != cur.next.val:
				cur = cur.next
			else:
				tmp = cur
				while cur.next and cur.val == cur.next.val:
					cur = cur.next
				tmp.next = cur.next
				cur.next = None
				cur = tmp.next
		return head