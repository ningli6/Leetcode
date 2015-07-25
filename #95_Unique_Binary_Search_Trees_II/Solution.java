import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int leftbound, int rightbound) {
    	List<TreeNode> result = new ArrayList<TreeNode>();
    	if (leftbound > rightbound) {
    		result.add(null); // this is the trick!
    		return result;
    	}
    	for (int i = leftbound; i <= rightbound; i++) {
	    	List<TreeNode> left = generateTrees(leftbound, i - 1);
	    	List<TreeNode> right = generateTrees(i + 1, rightbound);
	    	for (TreeNode lnd : left) {
	    		for (TreeNode rnd : right) {
	    			if (lnd == null) System.out.println("left is null");
	    			TreeNode root = new TreeNode(i);
	    			root.left = lnd;
	    			root.right = rnd;
	    			result.add(root);
	    		}
	    	}
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<TreeNode> result = sol.generateTrees(3);
    }
}