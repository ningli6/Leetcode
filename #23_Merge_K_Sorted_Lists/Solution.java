/* A solution based on min PQ */

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        /* new comparator */
        PriorityQueue<ListNode> minPQ = new PriorityQueue<ListNode>(lists.length, 
        	new Comparator<ListNode>() {
        		@Override
        		public int compare(ListNode nd1, ListNode nd2) {
        			return nd1.val - nd2.val;
        		}
        });
        for (ListNode node : lists) {
        	if (node != null) {
        		minPQ.add(node);
        	}
        }
        if (minPQ.isEmpty()) return null;
        while (!minPQ.isEmpty()) {
        	ListNode min = minPQ.poll();
        	cur.next = min;
        	cur = min;
        	min = min.next;
        	if (min != null) minPQ.add(min);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	ListNode head1 = new ListNode(1);
    	ListNode nd1= new ListNode(5);
    	ListNode nd2 = new ListNode(10);
    	head1.next = nd1;
    	nd1.next = nd2;
    	ListNode head2 = new ListNode(3);
    	ListNode nd3= new ListNode(7);
    	ListNode nd4 = new ListNode(11);
    	head2.next = nd3;
    	nd3.next = nd4;
    	ListNode[] lists = new ListNode[2];
    	lists[1] = head1;
    	lists[0] = head2;
    	ListNode result = sol.mergeKLists(lists);
    	while (true) {
    		System.out.println(result.val);
    		result = result.next;
    		if (result == null) break;
    	}
    }
}