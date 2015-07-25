class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @param {integer} k
	# @return {ListNode}
	def rotateRight(self, head, k):
		if not head or k == 0:
			return head
		len = 0
		cur = head
		while cur:
			cur = cur.next
			len += 1
		k = k % len  # mod
		if k == 0:
			return head
		k = len - k
		cur = head
		while k > 1:
			cur = cur.next
			k -= 1
		newHead = cur.next # cut the list
		cur.next = None
		cur = newHead
		while cur.next:
			cur = cur.next
		cur.next = head
		return newHead


sol = Solution()
n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n5 = ListNode(5)
n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
node = sol.rotateRight(n1, 2)
# node = sol.reverse(n1, n3)
while node:
	print node.val,
	node = node.next
