class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeElements(self, head, val):
    	dummy = ListNode(0)
    	dummy.next = head
    	prev = dummy
    	cur = head
    	while cur:
    		if cur.val == val:
    			tmp = cur.next
    			cur.next = None
    			cur = tmp
    			prev.next = cur
    		else:
    			prev = prev.next
    			cur = cur.next
    	return dummy.next

sol = Solution()
head = ListNode(1)
n1 = ListNode(2)
n2 = ListNode(4)
n3 = ListNode(10)
head.next = n1
n1.next = n2
n2.next = n3
print sol.removeElements(head, 9).val