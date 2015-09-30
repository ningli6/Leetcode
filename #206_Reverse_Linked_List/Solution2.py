'''
Recursive approach
'''

# Definition for singly-linked list.
class ListNode(object):
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution(object):
	def reverseList(self, head):
		if not head or not head.next:
			return head
		next = head.next
		nhead = self.reverseList(next)
		next.next = head
		head.next = None
		return nhead