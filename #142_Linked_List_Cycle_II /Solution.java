import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode cur = head;
        while (cur != null) {
        	if (set.contains(cur)) return cur;
        	set.add(cur);
        	cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode head = new ListNode(0);
    	ListNode c1 = new ListNode(1);
    	ListNode c2 = new ListNode(2);
    	ListNode c3 = new ListNode(4);
    	ListNode c4 = new ListNode(5);
    	head.next = c1;
    	c1.next = c2;
    	c2.next = c3;
    	c3.next = c4;
		c4.next = head;
    	System.out.println(sol.detectCycle(head).val);
    }
}