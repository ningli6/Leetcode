class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @param {integer} x
	# @return {ListNode}
	def partition(self, head, x):
		left = ListNode(0)
		right = ListNode(0)
		leftCur = left
		rightCur = right
		cur = head
		while cur:
			if cur.val < x:
				leftCur.next = cur
				leftCur = leftCur.next
			else:
				rightCur.next = cur
				rightCur = rightCur.next
			cur = cur.next
			leftCur.next = None
			rightCur.next = None
		leftCur.next = right.next
		right.next = None
		return left.next