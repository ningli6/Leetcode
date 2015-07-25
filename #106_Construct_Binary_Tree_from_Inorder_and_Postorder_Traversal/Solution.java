import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        if (postorder == null || postorder.length == 0) return null;
        if (inorder.length != postorder.length) return null;
        int len = inorder.length;
        map = new HashMap();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1); // [s, e];
    }

    private TreeNode buildTree(int[] inorder, int si, int ei, int[] postorder, int sp, int ep) {
    	if (si > ei || sp > ep) return null;
    	TreeNode node = new TreeNode(postorder[ep]);
    	int leftNums = map.get(postorder[ep]) - si;
    	node.left = buildTree(inorder, si, map.get(postorder[ep]) - 1, postorder, sp, sp + leftNums - 1);
    	node.right = buildTree(inorder, map.get(postorder[ep]) + 1, ei, postorder, sp + leftNums, ep - 1);
    	return node;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] in = {1, 5, 6, 7, 9, 10, 13, 15, 17, 20};
    	int[] po = {1, 6, 9, 7, 5, 13, 17, 20, 15, 10};
    	TreeNode t = sol.buildTree(in, po);
    }
}