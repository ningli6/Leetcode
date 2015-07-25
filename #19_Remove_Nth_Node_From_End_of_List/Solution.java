import java.util.List;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> alist = new ArrayList<ListNode>();
        if (n == 0) return head;
        if (head == null) return head;
        ListNode cur = head;
        while(cur != null) {
        	alist.add(cur);
        	cur = cur.next;
        }
        int len = alist.size();
        int rm = len - n;
        if (rm == 0) return head.next;
        alist.get(rm - 1).next = alist.get(rm).next;
        alist.get(rm).next = null;
        return head;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode nd0 = new ListNode(0);
    	// ListNode nd1 = new ListNode(1);
    	// ListNode nd2 = new ListNode(2);
    	// ListNode nd3 = new ListNode(3);
    	// ListNode nd4 = new ListNode(4);
    	// ListNode nd5 = new ListNode(5);
    	// nd0.next = nd1;
    	// nd1.next = nd2;
    	// nd2.next = nd3;
    	// nd3.next = nd4;
    	// nd4.next = nd5;
    	ListNode cur = nd0;
    	while (cur != null) {
    		System.out.print(cur.val + " ");
    		cur = cur.next;
    	}
    	System.out.println();
    	ListNode head = sol.removeNthFromEnd(nd0, 1);
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.println();
    }
}