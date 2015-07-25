/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder.length == 0 || inorder.length == 0) return null;
    	boolean[] creat = new boolean[inorder.length];
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	/* number -> index */
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        HashMap<Integer, TreeNode> tree = new HashMap<Integer, TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        /* number -> treenode */
        tree.put(preorder[0], root);
	    creat[map.get(preorder[0])] = true;
        for (int i = 1; i < preorder.length; i++) {
        	int index = map.get(preorder[i]);
        	System.out.println("index:" + index);
        	/* look into its right side */
        	for (int j = index + 1; j < inorder.length; j++) {
        		if (creat[j]) {
        			// System.out.println("Find");
        			TreeNode p = tree.get(inorder[j]);
        			if (p.left == null) {
        				p.left = new TreeNode(preorder[i]);
        				tree.put(preorder[i], p.left);
        				creat[index] = true;
        				break;
        			}
        		}
        	}
        	if (!creat[index]) {
	        	/* look into its left side */
	        	for (int j = index - 1; j >= 0; j--) {
	        		if (creat[j]) {
	        			System.out.println("Find");
	        			TreeNode p = tree.get(inorder[j]);
	        			p.right = new TreeNode(preorder[i]);
	        			tree.put(preorder[i], p.right);
	        			creat[index] = true;
	        			break;
	        		}
	        	}	
	        }
        }
        return root;
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] pre = {1, 2};
    	int[] in = {1, 2};
    	TreeNode r = sol.buildTree(pre, in);
    	// r.inorder();
    }
}