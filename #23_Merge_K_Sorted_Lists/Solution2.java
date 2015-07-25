/* A Solution based on divide and conquer */

import java.util.*;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        int len = lists.length;
        ListNode[] left = new ListNode[len / 2];
        ListNode[] right = new ListNode[len - len / 2];
        for (int i = 0; i < len / 2; i++) left[i] = lists[i];
        for (int i = 0; i < len - len / 2; i++) right[i] = lists[len / 2 + i];
        return mergeTwoLists(mergeKLists(left), mergeKLists(right));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
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