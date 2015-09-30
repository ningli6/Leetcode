# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        if not node or not node.next:
        	return
        next = node.next
        while True:
        	node.val = next.val
        	if not next.next:
        		break
        	node = node.next
        	next = next.next
        node.next = None

sol = Solution()
head = ListNode(1)
n1 = ListNode(2)
n2 = ListNode(3)
n3 = ListNode(4)
head.next = n1
n1.next = n2
n2.next = n3
sol.deleteNode(n2)
while head:
	print head.val,
	head = head.next 