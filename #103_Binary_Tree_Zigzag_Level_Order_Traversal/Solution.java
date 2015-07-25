import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if (root == null) return result;
        int cur = 0, next = 0, level = 0;
        Deque<TreeNode> queue = new LinkedList();
        List<Integer> levelList = new LinkedList();
        queue.add(root);
        cur = 1;
        while (!queue.isEmpty()) {
        	cur--;
        	TreeNode node = queue.remove();
			levelList.add(root.val);
        	if (node.left != null) {
        		queue.add(node.left);
        		next++;
        	}
        	if (node.right != null) {
        		queue.add(node.right);
        		next++;
        	}
        	if (cur == 0) {
        		if (level % 2 == 1) Collections.reverse(levelList);
        		result.add(levelList);
        		levelList = new LinkedList();
        		level++;
        		cur = next;
        		next = 0;
        	}
        }
        return result;
    }
}