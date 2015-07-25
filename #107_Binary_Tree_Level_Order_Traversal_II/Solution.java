import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);
        int cur = 1;
        int next = 0;
        List<Integer> list = new LinkedList();
        while (!queue.isEmpty()) {
        	cur--;
        	TreeNode node = queue.remove();
        	list.add(node.val);
        	if (node.left != null) {
        		queue.add(node.left);
        		next++;
        	}
        	if (node.right != null) {
        		queue.add(node.right);
        		next++;
        	}
        	if (cur == 0) {
        		cur = next;
        		next = 0;
        		result.add(list);
        		list = new LinkedList();
        	}
        }
        Collections.reverse(result);
        return result;
    }
}