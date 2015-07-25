import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int cur = 1;
        int next = 0;
        while (!queue.isEmpty()) {
        	TreeNode node = queue.remove();
        	// System.out.println("pop: " + node.val);
        	cur--;
        	if (node.left != null) {
        		queue.add(node.left);
        		next++;
        	}
        	if (node.right != null) {
        		queue.add(node.right);
        		next++;
        	}
        	if (cur == 0) {
        		result.add(node.val);
        		cur = next;
        		next = 0;
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	TreeNode head = new TreeNode(1);
    	TreeNode n1 = new TreeNode(2);
    	TreeNode n2 = new TreeNode(3);
    	head.left = n1;
    	head.right = n2;
    	Solution sol = new Solution();
    	List<Integer> result = sol.rightSideView(head);
    	for (Integer it : result) {
    		System.out.println(it);
    	}
    }
}