import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	int target = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) return false;
    	target = sum;
    	// dfs
    	return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int sum) {
    	sum += root.val;
    	// only check at leaf
    	if (root.left == null && root.right == null) return (sum == target) ? true : false;
    	if (root.left != null) {
    		if (dfs(root.left, sum)) return true;
    	}
    	if (root.right != null) {
    		if (dfs(root.right, sum)) return true;
    	}
    	return false;
    }
}