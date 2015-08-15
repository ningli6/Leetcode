class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def deleteDuplicates(self, head):
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        cur = head
        dup = False
        while cur and cur.next:
        	if cur.next.val != cur.val:
        		cur = cur.next
        		prev = prev.next
        	else:
        		dup = True
        		while cur.next and cur.next.val == cur.val:
        			cur = cur.next
        		prev.next = cur.next
        		cur.next = None
        		cur = prev.next
        		dup = False
        return dummy.next

sol = Solution()
h = ListNode(1)
n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(3)
h.next = n1
n1.next = n2
n2.next = n3
n3.next = n4
cur = sol.deleteDuplicates(h)
while cur:
	print cur.val
	cur = cur.next