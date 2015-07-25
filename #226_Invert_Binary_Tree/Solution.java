import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    /* Stack overflow! */
    // public TreeNode invertTree(TreeNode root) {
    //  if (root == null) return root;
    //  TreeNode left = root.left;
    //  TreeNode right = root.right;
    //  root.left = right;
    //  root.right = left;
    //  invertTree(root.left);
    //  invertTree(root.right);
    //  return root;
    // }

    /* Use a explicit stack */
    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) return root;
    //     Deque<TreeNode> stack = new LinkedList<TreeNode>();
    //     stack.add(root);
    //     while (!stack.isEmpty()) {
    //         TreeNode node = stack.pop();
    //         // switch left and right
    //         TreeNode left = node.left;
    //         TreeNode right = node.right;
    //         node.left = right;
    //         node.right = left;
    //         if (node.left != null) stack.push(node.left);
    //         if (node.right != null) stack.push(node.right);
    //     }
    //     return root;
    // }
    // 
    /* BFS iterative approach */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            // switch left and right
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}