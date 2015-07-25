class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode sorted = head;
		while (sorted.next != null) { // handle only one element
			ListNode cur = sorted.next;
			/* new value is max */
			if (cur.val >= sorted.val) {
				sorted = cur;
				continue;
			}
			ListNode search = dummy.next;
			ListNode prev = dummy;
			sorted.next = cur.next;
			/* min value */
			if (cur.val <= search.val) {
				cur.next = search;
				dummy.next = cur;
				continue;
			}
			/* go thru the sorted part */
			while (search.val < cur.val) {
				prev = prev.next;
				search = search.next;
			}
			prev.next = cur;
			cur.next = search;
		}
		return dummy.next;
    }
}