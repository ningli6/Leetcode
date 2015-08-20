# Definition for singly-linked list.
class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @return {ListNode}
	def sortList(self, head):
		dummy = ListNode(0)
		dummy.next = head
		sz = 1               # size of the list that will be merged
		length = self.lenList(head)
		while sz < length:   # if the whole list is not long enough for the other sub list, merge is over
			cur = dummy.next # start from first node
			last = dummy     # tail node of previous merged lists
			while cur:
				prev = last
				h1 = cur     # first sub list
				for x in range(sz):
					if not cur:
						break
					cur = cur.next
					prev = prev.next
				tmp = prev   # end of first sub list
				h2 = cur     # second sub list
				if not h2:   # no second sub list, break
					break
				for x in range(sz):
					if not cur:
						break
					cur = cur.next
					prev = prev.next
				tmp.next = None  # cut out first sub list
				prev.next = None # cut out second sub list
				[newH, newT] = self.mergeTwoList(h1, h2)
				last.next = newH
				newT.next = cur
				last = newT  # update tail node of previously merged lists
			sz <<= 1
		return dummy.next


	# merge two sorted list, return [head, tail]
	def mergeTwoList(self, h1, h2):
		if not h1:
			return h2
		if not h2:
			return h1
		dummy = ListNode(0)
		c1, c2 = h1, h2
		cur = dummy
		while c1 or c2:
			if c1 and c2:
				if c1.val < c2.val:
					cur.next = c1
					c1 = c1.next
				else:
					cur.next = c2
					c2 = c2.next
			elif c1:
				cur.next = c1
				c1 = c1.next
			else:
				cur.next = c2
				c2 = c2.next
			cur = cur.next
		return [dummy.next, cur]

	def lenList(self, head):
		count = 0
		while head:
			count += 1
			head = head.next
		return count

	def traverse(self, head):
		while head:
			print head.val,
			head = head.next

sol = Solution()
n0 = ListNode(3)
n1 = ListNode(4)
n2 = ListNode(1)
n3 = ListNode(5)
n0.next = n1
n1.next = n2
n2.next = n3
sol.traverse(sol.sortList(n0))

# n0 = ListNode(1)
# n1 = ListNode(4)
# n2 = ListNode(2)
# n3 = ListNode(3)
# n0.next = n1
# n2.next = n3
# sol.traverse(sol.mergeTwoList(n0, n2)[0])