class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tailA; int lenA = 0; ListNode tailB; int lenB = 0;
        ListNode cur = headA;
        while (cur != null) {
        	lenA++;
        	cur = cur.next;
        }
        tailA = cur;
        cur = headB;
        while(cur != null) {
        	lenB++;
        	cur = cur.next;
        }
        tailB = cur;
        if (tailB != tailA) return null;
        int diff = lenA - lenB;
        cur = (diff > 0) ? headA : headB;
        diff = Math.abs(diff);
        ListNode head = (cur == headA) ? headB : headA;
        while(diff > 0) {
        	cur = cur.next;
        	diff--;
        }
        while (cur != null && head != null) {
        	if (cur == head) return head;
        	cur = cur.next;
        	head = head.next;
        }
        return null;
    }
}