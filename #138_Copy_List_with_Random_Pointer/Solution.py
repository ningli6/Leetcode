# Definition for singly-linked list with a random pointer.
class RandomListNode:
	def __init__(self, x):
		self.label = x
		self.next = None
		self.random = None

class Solution:
	# @param head, a RandomListNode
	# @return a RandomListNode
	def copyRandomList(self, head):
		if not head:
			return head
		nodeMap = {}
		newHead = RandomListNode(head.label)
		curOri = head.next
		curCp = newHead
		nodeMap[head] = newHead
		while curOri:
			cpNode = RandomListNode(curOri.label)
			nodeMap[curOri] = cpNode
			curCp.next = cpNode
			curCp = cpNode
			curOri = curOri.next
		curOri = head
		curCp = newHead
		while curOri:
			if curOri.random:
				curCp.random = nodeMap[curOri.random]
			curOri = curOri.next
			curCp = curCp.next
		return newHead

head = RandomListNode(1)
head.next = RandomListNode(2)
head.random = head.next
sol = Solution()
print sol.copyRandomList(head).label
print sol.copyRandomList(head).next.label
print sol.copyRandomList(head).random.label