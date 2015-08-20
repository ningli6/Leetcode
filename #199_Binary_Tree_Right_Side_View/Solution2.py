# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def rightSideView(self, root):
    	re = []
    	self.dfs(root, 0, re)
    	return re

    def dfs(self, root, height, rsv):
    	if not root:
    		return
    	if height == len(rsv):
    		rsv.append(root.val)
    	else:
    		rsv[height] = root.val
    	self.dfs(root.left, height + 1, rsv)
    	self.dfs(root.right, height + 1, rsv)

sol = Solution()
root = TreeNode(10)
root.left = TreeNode(1)
root.right = TreeNode(20)
root.left.left = TreeNode(-3)
# root.right.right = TreeNode(50)
print sol.rightSideView(root)