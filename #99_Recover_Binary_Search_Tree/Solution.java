class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int bug1, bug2;
    int count;
    int prev;
    public void recoverTree(TreeNode root) {
		if (root == null) return;
		bug1 = bug2 = 0;
		count = 0;
		prev = Integer.MIN_VALUE;
		inorder(root);
		// System.out.println(bug1 + ", " + bug2);
		inorderFix(root);
    }

    private void inorder(TreeNode node) {
    	if (node == null) return;
    	inorder(node.left);
    	if (node.val < prev) {
    		if (count == 0) {
    			// System.out.println("update bug1");
    			bug1 = prev;
    			bug2 = node.val;
    			count++;
    		}
    		else {
    			// System.out.println("update bug2");
    			bug2 = node.val;
    		}
    	}
    	prev = node.val;
    	inorder(node.right);
    }

    private void inorderFix(TreeNode node) {
    	if (node == null) return;
    	inorderFix(node.left);
    	if (node.val == bug1) {
    		node.val = bug2;
    	}
    	else if (node.val == bug2) {
    		node.val = bug1;
    	}
    	inorderFix(node.right);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	TreeNode head = new TreeNode(0);
    	TreeNode node = new TreeNode(1);
    	head.left = node;
    	sol.recoverTree(head);
    }
}