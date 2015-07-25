class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        /* first node for each level */
        TreeLinkNode node = root;
        /* node for current level */
        TreeLinkNode cur = null;
        /* prev node on this level */
        TreeLinkNode prev = null;
        while(node != null) {
        	cur = node;
        	prev = null;
        	/* connect nodes from left to right on this level */
        	while (cur != null) {
        		if (prev != null) {
        			if (cur.left != null) prev.next = cur.left;
        			else if (cur.right != null) prev.next = cur.right;
        		}
        		if (cur.left != null && cur.right != null) {
        			cur.left.next = cur.right;
        			prev = cur.right;
        		}
        		else if (cur.left != null) prev = cur.left;
        		else if (cur.right != null) prev = cur.right;
        		cur = cur.next; 	// node proceeds
        	}
        	/* find new starting node for next level */
        	cur = node;
        	node = null;
        	while (cur != null) {
        		if (cur.left != null) {
        			node = cur.left; // if found, break
        			break;
        		}
        		else if (cur.right != null) {
        			node = cur.right; // if found, break
        			break;
        		}
        		cur = cur.next;
        	}
        }
    }

    public static void main(String[] args) {
    	TreeLinkNode root = new TreeLinkNode(-1);
    	TreeLinkNode nd1 = new TreeLinkNode(-7);
    	TreeLinkNode nd2 = new TreeLinkNode(9);
    	TreeLinkNode nd3 = new TreeLinkNode(-1);
    	TreeLinkNode nd4 = new TreeLinkNode(-7);
    	TreeLinkNode nd5 = new TreeLinkNode(8);
    	TreeLinkNode nd6 = new TreeLinkNode(-9);
    	root.left = nd1;
    	root.right = nd2;
    	nd2.left = nd3;
    	nd2.right = nd4;
    	nd3.right = nd5;
    	nd4.left = nd6;
    	Solution sol = new Solution();
    	sol.connect(root);
    }
}