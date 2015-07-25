/* Explicit stack, time O(n), space O(log(n)) */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList();
		if (root == null) return result;
		Deque<TreeNode> stack = new LinkedList();
		/* condition: stack is empty or root is null 
		 * root is not null, add it to stack
		 * root is null, pop from stack 
		 */
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
    }
}