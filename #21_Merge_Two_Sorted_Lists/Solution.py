class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def mergeTwoLists(self, l1, l2):
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