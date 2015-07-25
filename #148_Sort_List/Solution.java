class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static ListNode sortList(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
        	len++;
        	cur = cur.next;
        }
        if (len == 1) return head;
        int level = 0;
        int count = 1;
        while (count <= len) {
        	level++;
        	count *= 2;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int i = 0; i < level; i++) {
        	int jump = (int) Math.pow(2, i);
        	cur = dummyHead.next;
        	ListNode prev = dummyHead;
        	while (cur != null) {
        		ListNode list1 = cur;
        		for (int j = 0; j < jump; j++) {
        			if (j == jump - 1) {
        				ListNode tmp = cur;
        				cur = cur.next;
        				tmp.next = null;
        			}
        			else cur = cur.next;
        			if (cur == null) break;
        		}
    			if (cur == null) break;
        		ListNode list2 = cur;
        		for (int j = 0; j < jump; j++) {
        			if (j == jump - 1) {
        				ListNode tmp = cur;
        				cur = cur.next;
        				tmp.next = null;
        			}
        			else cur = cur.next;
        			if (cur == null) break;
        		}
        		ListNode newHead = mergeTwoSortedList(list1, list2);
        		prev.next = newHead;
        		ListNode last = findLast(newHead);
        		prev = last;
        		last.next = cur;
        	}
        }
        return dummyHead.next;
    }

    public static ListNode mergeTwoSortedList(ListNode node1, ListNode node2) {
    	ListNode dummyHead = new ListNode(-1);
    	if (node1 == null) return node2;
    	if (node2 == null) return node1;
    	ListNode cur1 = node1;
    	ListNode cur2 = node2;
    	ListNode cur = null;
    	while (cur1 != null && cur2 != null) {
    		ListNode smaller = (cur1.val < cur2.val) ? cur1 : cur2;
    		if (dummyHead.next == null) {
    			dummyHead.next = smaller;
    			cur = smaller;
    		}
    		else {
    			cur.next = smaller;
    			cur = cur.next;
    		}
    		if (cur1 == smaller) cur1 = cur1.next;
    		else cur2 = cur2.next;
    	}
    	ListNode res = (cur1 != null) ? cur1 : cur2;
    	while (res != null) {
    		cur.next = res;
    		cur = cur.next;
    		res = res.next;
    	}
    	return dummyHead.next;
    }

    private static ListNode findLast(ListNode head) {
    	if (head == null) return null;
    	ListNode cur = head;
    	while (cur.next != null) {
    		cur =cur.next;
    	}
    	return cur;
    }

    public static void main(String[] args) {
    	ListNode node0 = new ListNode(5);
    	ListNode node1 = new ListNode(1);
    	// ListNode node2 = new ListNode(7);
    	// ListNode node3 = new ListNode(2);
    	// ListNode node4 = new ListNode(8);
    	// ListNode node5 = new ListNode(10);
    	// ListNode node6 = new ListNode(3);
    	// ListNode node7 = new ListNode(4);
    	node0.next = node1;
    	// node1.next = node2;
    	// node2.next = node3;
    	// node3.next = node4;
    	// node4.next = node5;
    	// node5.next = node6;
    	// node6.next = node7;
    	ListNode result = Solution.sortList(node0);
    	ListNode cur = result;
    	while (cur != null) {
    		System.out.print(cur.val + " ");
    		cur = cur.next;
    	}
    	System.out.println();
    }
}