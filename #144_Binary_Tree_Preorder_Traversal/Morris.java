/* Morris traversal, time O(n), space O(1) */

import java.util.*;

public class Morris {
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList();
		if (root == null) return result;
		while (root != null) {
			result.add(root.val);
			/* if root.left is not null, find rightmost node on its left subtree */
			if (root.left != null) {
				/* find rightmost node */
				TreeNode rm = root.left;
				while (rm != null) {
					if (rm.right == root) break;
					if (rm.right != null) rm = rm.right;
					else break;
				}
				/* if rightmost.right is root its self, it means left branch has been visited, 
				   print root, go to its right branch */
				if (rm.right == root) {
					rm.right = null;
					result.remove(result.size() - 1);
					// result.add(root.val);
					root = root.right;
				}
				/* otherwise, set rightmost.right to root */
				else {
					rm.right = root;
					root = root.left;
				}
			}
			/* if root.left is null, print its value, go back to its parent */
			else if (root.left == null) {
				// result.add(root.val);
				root = root.right;
			}
		}
		return result;
    }

    public static void main(String[] args) {
    	Morris sol = new Morris();
    	TreeNode head = new TreeNode(2);
    	TreeNode node1 = new TreeNode(3);
    	TreeNode node2 = new TreeNode(1);
    	head.left = node1;
    	node1.left = node2;
    	List<Integer> list = sol.preorderTraversal(head);
    	for (Integer it : list) {
    		System.out.println(it + " ");
    	}
    }
}