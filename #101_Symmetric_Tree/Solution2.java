/**
 * Iterative solution
 * Explicit stack use
 */

import java.util.*;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
        	TreeNode left = stack.pop();
        	TreeNode right = stack.pop();
        	if (left.val != right.val) return false;
        	if ((left.left == null || right.right == null) && !(left.left == null && right.right == null)) 
        		return false;
        	if (left.left != null) stack.push(left.left);
        	if (right.right != null) stack.push(right.right);
        	if ((left.right == null || right.left == null) && !(left.right == null && right.left == null)) 
        		return false;
        	if (left.right != null) stack.push(left.right);
        	if (right.left != null) stack.push(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	System.out.println(sol.isSymmetric(root));
    }
}