class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

	int count;
	TreeNode smallest;
	int re;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        smallest = null;
        re = 0;
        inorder(root);
        return re;
    }

    private boolean inorder(TreeNode node) {
    	if (node == null) return false;
    	if (inorder(node.left)) return true;
    	if (node.left == null && smallest == null) {
    		smallest = node;
    	}
    	if (smallest != null) count--;
    	if (count == 0) {
    		re = node.val;
    		return true;
    	}
    	return inorder(node.right);
    }
}