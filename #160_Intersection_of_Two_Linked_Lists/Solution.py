# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        if not headA or not headB:
        	return None
        if headA is headB:
        	return headA
        la = self.lenList(headA)
        lb = self.lenList(headB)
        while la > lb:
        	headA = headA.next
        	la -= 1
        while lb > la:
        	headB = headB.next
        	lb -= 1
        while headA and headB:
        	if headA is headB:
        		return headA
        	headA = headA.next
        	headB = headB.next
        return None

    def lenList(self, head):
    	count = 0
    	while head:
    		count += 1
    		head = head.next
    	return count

sol = Solution()
h1 = ListNode(0)
n3 = ListNode(3)
n1 = ListNode(1)
h2 = ListNode(0)
h1.next = n3
n3.next = n1
h2.next = n1
print sol.getIntersectionNode(h1, h2).val