# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def isPalindrome(self, head):
    	if not head or not head.next:
    		return True
    	len = self.listLen(head)
    	cur = head
    	for x in range(1, len / 2):
    		cur = cur.next
    	newH = cur.next
    	cur.next = None
    	newH = self.listReverse(newH)
    	while head and newH:
    		if head.val != newH.val:
    			return False
    		head = head.next
    		newH = newH.next
    	return True

    def listLen(self, head):
    	count = 0
    	while head:
    		count += 1
    		head = head.next
    	return count

    def listReverse(self, head):
    	if not head or not head.next:
    		return head
    	cur = head
    	next = cur.next
    	cur.next = None
    	while next:
    		tmp = next.next
    		next.next = cur
    		cur = next
    		next = tmp
    	return cur

sol = Solution()
head = ListNode(1)
n1 = ListNode(2)
n2 = ListNode(3)
# n3 = ListNode(1)
head.next = n1
n1.next = n2
# n2.next = n3
print sol.isPalindrome(head)