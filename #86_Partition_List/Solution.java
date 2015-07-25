class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode curLess = less;
        ListNode curGreater = greater;
        ListNode cur = head;
        while (cur != null) {
        	if (cur.val < x) {
        		curLess.next = cur;
        		curLess = curLess.next;
        	}
        	else {
        		curGreater.next = cur;
        		curGreater = curGreater.next;
        	}
        	cur = cur.next;
        }
        curLess.next = greater.next;
        curGreater.next = null;
        return less.next;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(4);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(2);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(2);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	ListNode nd = sol.partition(n1, 3);
    	while(nd != null) {
    		System.out.print(nd.val + " ");
    		nd = nd.next;
    	}
    	System.out.println();
    }
}