# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @return {void} Do not return anything, modify head in-place instead.
    def reorderList(self, head):
        len = self.listLen(head)
        if len < 3:
        	return
        step = (len + 1) / 2
        cur = head
        prev = None
        while step > 0:
        	if step == 1:
        		prev = cur
        	cur = cur.next
        	step -= 1
        	if prev:
        		prev.next = None
        newHead = self.revserse(cur)
        cur = head
        while newHead:
        	tmp = cur.next
        	cur.next = newHead
        	newHead = newHead.next
        	cur.next.next = tmp
        	cur = tmp

    # @param {ListNode} head
    # @return {integer} length of the list
    def listLen(self, head):
    	count = 0
    	while head:
    		count += 1
    		head = head.next
    	return count

    # reverse list
    def revserse(self, head):
    	if not head or not head.next:
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

    def traverse(self, head):
    	while head:
    		print head.val
    		head = head.next

sol = Solution()
head = ListNode(1)
n1 = ListNode(2)
n2 = ListNode(3)

head.next = n1
n1.next = n2

sol.reorderList(head)
sol.traverse(head)