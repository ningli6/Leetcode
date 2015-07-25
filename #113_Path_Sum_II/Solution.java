import java.util.*;

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	int target;
	List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new LinkedList();
        if (root == null) return result;
        target = sum;
        LinkedList<Integer> path = new LinkedList();
        // dfs
        dfs(root, 0, path);
        return result;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> path) {
    	path.add(root.val);
    	sum += root.val;
    	if (root.left == null && root.right == null) {
    		if (sum == target) {
    			result.add(new LinkedList(path));
    		}
    	}
    	if (root.left != null) dfs(root.left, sum, path);
    	if (root.right != null) dfs(root.right, sum, path);
    	sum -= path.removeLast();
    }
}