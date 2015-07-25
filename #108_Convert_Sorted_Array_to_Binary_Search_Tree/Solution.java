class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode head = addNode(nums, 0, nums.length - 1);
        return head;
    }

    private TreeNode addNode(int[] nums, int lo, int hi) {
    	if (lo > hi) return null;
    	int mid = (lo + hi) / 2;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = addNode(nums, lo, mid - 1);
    	node.right = addNode(nums, mid + 1, hi);
    	return node;
    }

    public static void inorderTraversal(TreeNode head) {
    	if (head == null) return;
    	inorderTraversal(head.left);
    	System.out.println(head.val);
    	inorderTraversal(head.right);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] test = {1, 2, 3, 4, 5, 6};
    	TreeNode head = sol.sortedArrayToBST(test);
    	Solution.inorderTraversal(head);
    }
}