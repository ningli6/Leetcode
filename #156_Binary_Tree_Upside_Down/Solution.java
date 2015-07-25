class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) return null;
		postOrder(root);
		root.left = null;
		root.right = null;
		return newRoot;
    }

    private TreeNode postOrder(TreeNode root) {
    	if (root.left == null) {
    		newRoot = root;
    		return newRoot;
    	}
    	TreeNode cur = postOrder(root.left);
    	cur.left = root.right;
    	cur.right = root;
    	return root;
    }
}