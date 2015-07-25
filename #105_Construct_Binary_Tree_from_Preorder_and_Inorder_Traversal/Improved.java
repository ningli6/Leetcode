public class Improved {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) return null;
		return construct(preorder, inorder, 0, 0, preorder.length - 1);
	}

	private TreeNode construct(int[] preorder, int[] inorder, int preStart, int start ,int end) {
		if (start > end) return null;
		int preStartindex = 0;
		for (int i = start; i <= end; i++) {
			if (inorder[i] == preorder[preStart])
				preStartindex = i;
		}
		TreeNode node = new TreeNode(preorder[preStart]);
		node.left = construct(preorder, inorder, preStart + 1, start, preStartindex - 1);
		node.right = construct(preorder, inorder, preStart + preStartindex - start + 1, preStartindex + 1, end);
		return node;
	}
	public static void main(String[] args) {
		Improved sol = new Improved();
		int[] pre = {1, 2};
		int[] in = {2, 1};
		sol.buildTree(pre, in);
	}
}