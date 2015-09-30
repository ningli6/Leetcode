# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root or not p or not q:
        	return None
        if p.val == q.val:
        	return p
        if p.val > q.val:
        	return self.lowestCommonAncestor(root, q, p)
        if root.val > q.val:
        	return self.lowestCommonAncestor(root.left, p, q)
        if root.val < p.val:
        	return self.lowestCommonAncestor(root.right, p, q)
        if root.val >= p.val and root.val <= q.val:
        	return root
        return None

sol = Solution()
root = TreeNode(10)
n1 = TreeNode(3)
n2 = TreeNode(12)
root.left = n1
root.right = n2
print sol.lowestCommonAncestor(root, n1, n2).val