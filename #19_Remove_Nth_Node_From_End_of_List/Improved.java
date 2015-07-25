public class Improved {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) return head;
    	ListNode slow = head; ListNode fast = head;
    	for (int i = 0; i < n; i++) {
    		fast = fast.next;
    	}
    	if (fast == null) return head.next;
    	while(fast.next != null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	ListNode cur = slow.next;
    	slow.next = cur.next;
    	cur.next = null;
    	return head;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode nd0 = new ListNode(0);
    	ListNode nd1 = new ListNode(1);
    	ListNode nd2 = new ListNode(2);
    	ListNode nd3 = new ListNode(3);
    	ListNode nd4 = new ListNode(4);
    	ListNode nd5 = new ListNode(5);
    	nd0.next = nd1;
    	nd1.next = nd2;
    	nd2.next = nd3;
    	nd3.next = nd4;
    	nd4.next = nd5;
    	ListNode cur = nd0;
    	while (cur != null) {
    		System.out.print(cur.val + " ");
    		cur = cur.next;
    	}
    	System.out.println();
    	ListNode head = sol.removeNthFromEnd(nd0, 6);
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.println();
    }
}