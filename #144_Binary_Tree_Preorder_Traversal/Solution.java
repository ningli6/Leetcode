import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList();
		if (root == null) return result;
		Deque<TreeNode> stack = new LinkedList();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			else {
				root = stack.pop();
				root = root.right;
			}
		}
		return result;
    }
}