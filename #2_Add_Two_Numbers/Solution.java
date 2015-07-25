class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur1 = l1; ListNode cur2 = l2;
        int rem = 0;
        while (cur1 != null && cur2 != null) {
        	int val = cur1.val + cur2.val + rem;
        	ListNode nd = new ListNode(val % 10);
        	rem = val / 10;
        	prev.next = nd;
        	prev = nd;
        	cur1 = cur1.next;
        	cur2 = cur2.next;
        }
        while (cur1 != null) {
        	int val = cur1.val + rem;
        	ListNode nd = new ListNode(val % 10);
        	rem = val / 10;
        	prev.next = nd;
        	prev = nd;
        	cur1 = cur1.next;
        }
        while (cur2 != null) {
        	int val = cur2.val + rem;
        	ListNode nd = new ListNode(val % 10);
        	rem = val / 10;
        	prev.next = nd;
        	prev = nd;
        	cur2 = cur2.next;
        }
        if (rem > 0) {
        	ListNode nd = new ListNode(rem);
        	prev.next = nd;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode h1 = new ListNode(2);
    	ListNode n2 = new ListNode(4);
    	ListNode n3 = new ListNode(3);
    	h1.next = n2;
    	n2.next = n3;
    	ListNode h2 = new ListNode(5);
    	ListNode n4 = new ListNode(6);
    	ListNode n5 = new ListNode(4);
    	h2.next = n4;
    	n4.next = n5;
    	ListNode r = sol.addTwoNumbers(h1, h2);
    	while (r != null) {
    		System.out.print(r.val + " ");
    		r = r.next;
    	}
    	System.out.println();
    }
}