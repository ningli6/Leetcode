/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) head = head.next;
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
        	if (cur.val == val) {
        		prev.next = cur.next;
        		cur = cur.next;
        	}
        	else {
        		prev = prev.next;
        		cur = cur.next;
        	}
        }
        return head;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode head = new ListNode(2);
    	ListNode node1 = new ListNode(2);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(2);
    	head.next = node1;
    	node1.next = node2;
    	node2.next = node3;
    	ListNode.printList(head);
    	ListNode.printList(sol.removeElements(head, 2));
    }
}