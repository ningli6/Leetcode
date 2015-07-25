/* A solution using explicit stack (iterative) */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList();
    	if (root == null) return result;
    	Deque<TreeNode> stack = new LinkedList();
    	while (root != null || !stack.isEmpty()) {
    		if (root != null) {
	    		result.add(root.val);
    			stack.push(root);
    			root = root.right;
    		}
    		else {
    			root = stack.pop();
    			root = root.left;
    		}
    	}
    	Collections.reverse(result);
    	return result;
    }
}