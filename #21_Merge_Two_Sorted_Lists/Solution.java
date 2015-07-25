class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newCur = null;
        ListNode newHead = null;
        while (cur1 != null && cur2 != null) {
        	ListNode node = cur2;
        	if (cur1.val < cur2.val) node = cur1;
    		if (newHead == null) {
    			newHead = node;
        		newCur = newHead;
    		}
    		else {
	    		newCur.next = node;
	    		newCur = node;
    		}
    		if (node == cur2) cur2 = cur2.next;
    		else cur1 = cur1.next;
        }
        while (cur1 != null) {
        	newCur.next = cur1;
        	newCur = cur1;
        	cur1 = cur1.next;
        }
        while (cur2 != null) {
        	newCur.next = cur2;
        	newCur = cur2;
        	cur2 = cur2.next;
        }
        return newHead;
    }
}