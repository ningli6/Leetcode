class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        slow = head
        fast = head
        while fast and fast.next:
        	fast = fast.next.next
        	slow = slow.next
        	if fast is slow:
        		fast = head
        		while fast is not slow:
        			fast = fast.next
        			slow = slow.next
        		return fast
        return None

head = ListNode(2)
sol = Solution()
sol.detectCycle(None)