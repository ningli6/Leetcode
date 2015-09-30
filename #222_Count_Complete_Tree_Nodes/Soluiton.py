# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
        	return 0
        leftHeight = self.leftPathHeight(root.left)
        rightHeight = self.leftPathHeight(root.right)
        if leftHeight == rightHeight:
        	return self.countNodes(root.right) + 2 ** leftHeight
        if leftHeight > rightHeight:
        	return self.countNodes(root.left) + 2 ** rightHeight

    # count the heght of left branch path of binary tree, including the root node
    def leftPathHeight(self, root):
    	count = 0
    	while root:
    		count += 1
    		root = root.left
    	return count

sol = Solution()
root = TreeNode(0)
root.left = TreeNode(1)
root.right = TreeNode(2)
print sol.countNodes(root)