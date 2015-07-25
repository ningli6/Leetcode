import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
    	List<Integer> inorder = new ArrayList<Integer>();
    	inorderTraversal(root, inorder);
    	int len = inorder.size();
    	if (len == 1) return true;
    	for (int i = 1; i < len; i++) {
    		if (inorder.get(i - 1) >= inorder.get(i)) return false;
    	}
    	return true;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> list) {
    	if (node == null) return;
    	inorderTraversal(node.left, list);
    	list.add(node.val);
    	inorderTraversal(node.right, list);
    }
}