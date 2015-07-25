import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {
	Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        if (node.right != null) {
        	node = node.right;
        	while (node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        }
        return res;
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	TreeNode right = new TreeNode(2);
    	root.right = right;
    	BSTIterator i = new BSTIterator(root);
    	while (i.hasNext()) {
    		System.out.println(i.next());
    	}
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */