import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public void reorderList(ListNode head) {
        int len = count(head);
        if (len < 3) return;
        // System.out.println("len: " + len);
        ListNode mid = head;
        for (int i = 0; i < (len / 2); i++) {
        	mid = mid.next;
        }
        // System.out.println("mid val: " + mid.val);
        /* reverse everything after this node */
        ListNode tail = reverse(mid);
        // System.out.println("tail val: " + tail.val);
        ListNode cur = head;
        while (tail != mid) {
        	ListNode tmp = cur.next;
        	cur.next = tail;
        	tail = tail.next;
        	cur.next.next = tmp;
        	cur = tmp;
        }
    }

    private int count(ListNode head) {
    	if (head == null) return 0;
    	int c = 0;
    	while (head != null) {
    		c++;
    		head = head.next;
    	}
    	return c;
    }

    /* return new list head */
    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode newHead = null;
    	ListNode p = head; ListNode c = head.next;
    	head.next = null; // set head.next = null, this is new tail
    	while (c != null) {
    		ListNode f = c.next;
    		c.next = p;
    		p = c; // order matters here
    		c = f;
    	}
    	return p;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode nd1 = new ListNode(1);
    	ListNode nd2 = new ListNode(2);
    	ListNode nd3 = new ListNode(3);
    	ListNode nd4 = new ListNode(4);
    	ListNode nd5 = new ListNode(5);
    	nd1.next = nd2;
    	nd2.next = nd3;
    	nd3.next = nd4;
    	nd4.next = nd5;
    	sol.reorderList(nd1);
    	while (nd1 != null) {
    		System.out.print(nd1.val + " ");
    		nd1 = nd1.next;
    	}
    	System.out.println();
    }
}