public class Solution2 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) return head;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		int count = 0;
		while (head != null || count == k) {
			if (count == k) {
				ListNode node = reverseK(prev, head);
				count = 0;
				prev = node;
			}
			if (head != null) head = head.next;
			count++;
		}
		return dummyHead.next;
    }

    /* reverse list from prev to next exclusively */
    private static ListNode reverseK(ListNode prev, ListNode next) {
    	// System.out.println("prev: " + prev.val);
    	ListNode p = prev.next;
    	// System.out.println("p: " + p.val);
    	ListNode c = p.next;
    	ListNode hold = p;
    	p.next = next;
    	while (c != null && c != next) {
    		ListNode tmp = c.next;
    		c.next = p;
    		p = c;
    		c = tmp;
    	}
    	prev.next = p;
    	return hold;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	ListNode head = new ListNode(1);
    	ListNode node1 = new ListNode(2);
    	// ListNode node2 = new ListNode(3);
    	// ListNode node3 = new ListNode(4);
    	// ListNode node4 = new ListNode(5);
    	head.next = node1;
    	// node1.next = node2;
    	// node2.next = node3;
    	// node3.next = node4;
    	ListNode result = sol.reverseKGroup(head, 2);
    	ListNode cur = result;
    	while (cur != null) {
    		System.out.print(cur.val + " ");
    		cur = cur.next;
    	}
    	System.out.println();
    }
}