class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:

    def __init__(self):
        self.ans = 0

    # @param {TreeNode} root
    # @return {integer}
    def maxPathSum(self, root):
        self.ans = 0
        self.maxBranch(root)
        return self.ans

    def maxBranch(self, root):
        if not root:
            return 0
        ld = max(0, self.maxBranch(root.left))
        rd = max(0, self.maxBranch(root.right))
        self.ans = max(self.ans, ld + rd + root.val)
        return max(ld, rd) + root.val

sol = Solution()
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(-15)
print sol.maxPathSum(root)