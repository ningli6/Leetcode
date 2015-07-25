class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null || head.next == null) return head;
    	int len = count(head);
    	k = k % len;
    	if (k == 0) return head;
    	ListNode cur = head;
    	for (int i = 0; i < len - k - 1; i++) {
    		cur = cur.next;
    	}
    	ListNode ret = cur.next;
    	cur.next = null;
    	cur = ret;
    	while(cur.next != null) cur = cur.next;
    	cur.next = head;
    	return ret;
    }

    private int count(ListNode head) {
    	int c = 0;
    	ListNode cur = head;
    	while (cur != null) {
    		c++;
    		cur = cur.next;
    	}
    	return c;
    }
}