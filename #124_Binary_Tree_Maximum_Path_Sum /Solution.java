/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        // int maxSum = 0;
        findSum(root);
        return maxSum;
    }

    private int findSum(TreeNode node) {
    	if (node == null) return 0;
    	int right = findSum(node.right);
    	int left = findSum(node.left);
    	if (right < 0) right = 0;
    	if (left < 0) left = 0;
    	if (right + left + node.val > maxSum) maxSum = right + left + node.val;
    	return Math.max(left, right) + node.val;
    }
}