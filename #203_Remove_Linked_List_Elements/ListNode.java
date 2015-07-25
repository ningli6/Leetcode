// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void printList(ListNode head) {
    	if (head == null) return;
    	while(head != null) {
    		if (head.next == null) System.out.print(head.val);
    		else System.out.print(head.val + "--->");
    		head = head.next; 
    	}
    	System.out.println();
    }
}