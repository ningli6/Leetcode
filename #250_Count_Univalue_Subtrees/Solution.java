
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnivalSubtrees(root);
        return count;
    }
    
    private boolean isUnivalSubtrees(TreeNode root) {
        if (root == null) return true;
        boolean left = isUnivalSubtrees(root.left);
        boolean right = isUnivalSubtrees(root.right);
        if (!left || !right) return false;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        count++;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        Solution sol = new Solution();
        System.out.println(sol.countUnivalSubtrees(root));
    }
}