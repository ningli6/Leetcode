# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        dummy = ListNode(-1)
        cur, iter1, iter2 = dummy, l1, l2
        sum = 0
        while iter1 or iter2 or sum == 1:
            if iter1:
            	sum += iter1.val
            	iter1 = iter1.next
            if iter2:
            	sum += iter2.val
            	iter2 = iter2.next
            cur.next = ListNode(sum % 10)
            cur = cur.next
            sum /= 10
        return dummy.next


n1 = ListNode(2)
n2 = ListNode(4)
n3 = ListNode(3)
m1 = ListNode(5)
m2 = ListNode(6)
m3 = ListNode(4)
n1.next = n2
n2.next = n3
m1.next = m2
m2.next = m3
sol = Solution()
re = sol.addTwoNumbers(n1, m1)
while re != None:
	print re.val
	re = re.next