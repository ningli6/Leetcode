class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
	# @param {ListNode} head
	# @return {ListNode}
	def insertionSortList(self, head):
		minVal = -2147483648
		sortedHead = ListNode(minVal)
		cur = head
		maxNode = None
		while cur:
			if maxNode and maxNode.val <= cur.val:
				maxNode.next = cur
				maxNode = maxNode.next
				cur = cur.next
				maxNode.next = None
			else:
				if not maxNode:
					maxNode = cur
				prev = sortedHead
				search = prev.next
				while search and search.val < cur.val:
					search = search.next
					prev = prev.next
				tmp = cur.next
				prev.next = cur
				cur.next = search
				cur = tmp
		return sortedHead.next

	def traverse(self, head):
		while head:
			print head.val,
			head = head.next

sol = Solution()
n0 = ListNode(3)
n1 = ListNode(4)
n2 = ListNode(1)
n0.next = n1
n1.next = n2
# sol.traverse(n0)
# print
sol.traverse(sol.insertionSortList(n0))
# sol.insertionSortList(n0)