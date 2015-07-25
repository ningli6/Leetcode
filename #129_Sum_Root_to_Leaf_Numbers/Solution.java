class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	int result;
    public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		result = 0;
		dfs(root, 0);
		return result;
    }

    private void dfs(TreeNode root, int sum) {
    	sum = sum * 10 + root.val;
    	if (root.left == null && root.right == null) {
    		result += sum;
    		return;
    	}
    	if (root.left != null) dfs(root.left, sum);
    	if (root.right != null) dfs(root.right, sum);
    }
}