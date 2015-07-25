public class Improved {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
        	if (fast == null || fast.next == null) return null;
        	fast = fast.next.next;
        	slow = slow.next;
        	if (fast == slow) break;
        }
        fast = head;
        while (true) {
        	if (fast == slow) return fast;
        	fast = fast.next;
        	slow = slow.next;
        }
    }
}