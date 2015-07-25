class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode prev = null;
    	ListNode result = null;
    	ListNode cur = head;
    	while (cur != null && cur.next != null) {
    		if (result == null) result = cur.next;
    		if (prev != null) prev.next = cur.next;
    		ListNode tmp = cur.next.next;
    		cur.next.next = cur;
    		cur.next = tmp;
    		prev = cur;
    		cur = tmp;
    	}
    	return result;
    }
}