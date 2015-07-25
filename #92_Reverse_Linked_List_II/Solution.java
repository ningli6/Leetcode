class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode prev = null; ListNode next = null;
        ListNode end = null; ListNode start = null;
        ListNode fast = head; ListNode slow = head;
        if (m == n) return head;
        if (m == 1) {
        	start = head;
	        for (int i = 0; i < n - 1; i++) {
		    	fast = fast.next;
	        }
            end = fast; next = end.next;
	        reverseBetween(start, end);
	        start.next = next;
	        return end;
        }
        else {
	        for (int i = 0; i < n - m + 1; i++) {
	        	fast = fast.next;
	        }
	        for (int i = 0; i < m - 2 && m > 1; i++) {
	        	fast = fast.next;
	        	slow = slow.next;
	        }
            prev = slow; start = prev.next;
	        end = fast; next = end.next;
	        reverseBetween(start, end);
	        prev.next = end;
	        start.next = next;
	        return head;
        }
    }

    private static void reverseBetween(ListNode start, ListNode end) {
    	if (start == end) return;
    	ListNode prev = start; ListNode cur = start.next;
    	start.next = null;
    	while (cur != null) {
    		ListNode tmp = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = tmp;
    		if (prev == end) break;
    	}
    }
}