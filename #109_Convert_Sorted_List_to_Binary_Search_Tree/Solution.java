class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        node = head;
        int len = countList(head);
        return build(0, len - 1);
    }

    private TreeNode build(int lo, int hi) {
    	// System.out.println("lo: " + lo + "hi: " + hi);
    	if (lo > hi) return null;
    	int mid = (lo + hi) / 2;
    	TreeNode left = build(lo, mid - 1);
    	TreeNode center = new TreeNode(node.val);
    	node = node.next;
    	center.left = left;
    	center.right = build(mid + 1, hi);
    	return center;
    }

    private int countList(ListNode head) {
    	if (head == null) return 0;
    	int count = 0;
    	ListNode nd = head;
    	while (nd != null) {
    		count++;
    		nd = nd.next;
    	}
    	return count;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(0);
    	Solution sol = new Solution();
    	sol.sortedListToBST(head);
    }
}