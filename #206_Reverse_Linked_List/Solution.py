'''
Iterative approach
'''

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next: # list length <= 1
        	return head
        prev = head
        cur = head.next
        prev.next = None
        while cur:
        	tmp = cur.next
        	cur.next = prev
        	prev = cur
        	cur = tmp
        return prev