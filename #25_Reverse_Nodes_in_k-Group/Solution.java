class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode cur = head;
		ListNode prev = head;
		ListNode newLast = null;
		ListNode newHead = null;
		while (true) {
			for (int i = k; i > 0; i--) {
				if (cur == null) {
					return dummyHead.next;
				}
				cur = cur.next;
			}
			ListNode c = prev;
			ListNode n = prev.next;
			ListNode f = n.next;
			int count = 1;
			for (int i = count; i < k; i++) {
				n.next = c;
				c = n;
				n = f;
				if (f != null) f = f.next;
			} 
			prev.next = n;
			newHead = c;
			if (newLast == null) dummyHead.next = newHead;
			else newLast.next = newHead;
			newLast = prev;
			prev = cur;
		}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode head = new ListNode(1);
    	ListNode node1 = new ListNode(2);
    	head.next = node1;
    	ListNode result = sol.reverseKGroup(head, 2);
    	ListNode cur = result;
    	while (cur != null) {
    		System.out.print(cur.val + " ");
    		cur = cur.next;
    	}
    	System.out.println();
    }
}