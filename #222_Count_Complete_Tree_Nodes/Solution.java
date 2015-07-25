class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    /**
     * O(n) is not good enough for this 
     *   public int countNodes(TreeNode root) {
     *       if (root == null)
     *           return 0;
     *       return 1 + countNodes(root.left) + countNodes(root.right);
     *   }
     *
     * Below is a O(log(n) ^ 2) solution
     */

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = countHeight(root);
        int subr = countHeight(root.right);
        // System.out.println("Root: " + root.val);
        // System.out.println("h: " + h);
        // System.out.println("subr: " + subr);
        if (subr + 1 == h) {// left subtree is a full tree
            return (1 << h) + countNodes(root.right);
        }
        else {// right subtree is a full tree
            return (1 << (subr + 1)) + countNodes(root.left);
        }
    }

    private int countHeight(TreeNode node) {
        // since it's a complete tree, walk thru left branch can count the height
        // note that a single node has height 0
        return (node == null) ? -1 : 1 + countHeight(node.left);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        System.out.println(sol.countNodes(root));
    }
}
