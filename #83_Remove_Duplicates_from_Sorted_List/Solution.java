class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while(cur != null) {
        	while(cur.next != null && cur.next.val == cur.val) {
        		cur = cur.next;
        	}
        	if (prev.next == cur) {
        		prev = cur;
        	}
        	else {
        		prev = prev.next;
        		prev.next = cur.next;
        	}
        	cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode head = new ListNode(1);
    	ListNode cur = head;
    	cur.next = new ListNode(1);
    	cur = cur.next;
    	cur.next = new ListNode(1);
    	cur = cur.next;
    	cur.next = new ListNode(1);
    	cur = cur.next;
    	ListNode newHead = sol.deleteDuplicates(head);
    	cur = newHead;
    	while(cur != null) {
    		System.out.println(cur.val);
    		cur = cur.next;
    	}
    }
}