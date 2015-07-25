'''
Priority queue based Solution

time: O(log(k) * n), space O(k)
'''

# import Queue as Q

class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

# class Solution:
# 	# @param {ListNode[]} lists
# 	# @return {ListNode}
# 	def mergeKLists(self, lists):
# 		if not lists:
# 			return None
# 		if len(lists) == 1:
# 			return lists[0]
# 		dummy = ListNode(-1)
# 		ptr = dummy
# 		pq = Q.PriorityQueue()
# 		for head in lists:
# 			if head:
# 				pq.put((head.val, head))
# 		while not pq.empty():
# 			head = pq.get()[1]
# 			ptr.next = head
# 			head = head.next
# 			if head:
# 				pq.put((head.val, head))
# 			ptr = ptr.next
# 		return dummy.next

'''
Sort all nodes
time: O(log(n) * n), space(n)
This is practically faster because of partially sorted sequence
'''

# class Solution:
# 	# @param {ListNode[]} lists
# 	# @return {ListNode}
# 	def mergeKLists(self, lists):
# 		if not lists:
# 			return None
# 		if len(lists) == 1:
# 			return lists[0]
# 		sortedList = []
# 		for head in lists:
# 			while head:
# 				sortedList.append(head)
# 				head = head.next
# 		sortedList.sort(key=lambda ListNode: ListNode.val)
# 		for i in range(len(sortedList) - 1):
# 			sortedList[i].next = sortedList[i + 1]
# 		if not sortedList:
# 			return None
# 		return sortedList[0]

'''
divide and conquer
time: O(log(k) * n), space O(1)
'''

class Solution:
	# @param {ListNode[]} lists
	# @return {ListNode}
	def mergeKLists(self, lists):
		if not lists:
			return None
		if len(lists) == 1:
			return lists[0]
		mid = len(lists) / 2
		return self.merge2List(self.mergeKLists(lists[:mid]), self.mergeKLists(lists[mid:]))

	def merge2List(self, l1, l2):
		if not l1:
			return l2
		if not l2:
			return l1
		dummy = ListNode(-1)
		cur = dummy
		while l1 or l2:
			if not l1:
				node = l2
			elif not l2:
				node = l1
			else:
				if l1.val < l2.val:
					node = l1
				else:
					node = l2
			cur.next = node
			if node == l1:
				l1 = l1.next
			else:
				l2 = l2.next
			cur = cur.next
		return dummy.next

sol = Solution()
sol.mergeKLists([None])