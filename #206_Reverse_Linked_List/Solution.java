/* reverse a linked list with recursion */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode hd = reverse(head);
    	head.next = null;
    	return hd;
    }

    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode next = head.next;
    	ListNode hd = reverseList(head.next);
    	head.next = null;
    	next.next = head;
    	return hd;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode nd1 = new ListNode(1);
    	ListNode nd2 = new ListNode(2);
    	ListNode nd3 = new ListNode(3);
    	ListNode nd4 = new ListNode(4);
    	nd1.next = nd2;
    	nd2.next = nd3;
    	nd3.next = nd4;
    	ListNode hd = sol.reverseList(nd1);
    	while (hd != null) {
    		System.out.print(hd.val + " ");
    		hd = hd.next;
    	}
    	System.out.println();
    }
}