import java.util.*;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode node = root;
		TreeLinkNode cur = null;
		while (node != null) {
			cur = node;
			while (cur != null) {
				if (cur.left == null) return;
				cur.left.next = cur.right;
				if (cur.next != null) cur.right.next = cur.next.left;
				cur = cur.next;
			}
			node = node.left;
		}
	}
}