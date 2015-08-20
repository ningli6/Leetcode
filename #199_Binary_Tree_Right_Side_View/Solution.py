from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def rightSideView(self, root):
    	if not root:
    		return []
    	queue = deque([root])
    	re = []
    	cur, next = 1, 0
    	while queue:
    		node = None
    		for x in range(cur):
    			node = queue.popleft()
    			if node.left:
    				queue.append(node.left)
    				next += 1
    			if node.right:
    				queue.append(node.right)
    				next += 1
    		re.append(node.val)
    		cur = next
    		next = 0
    	return re

sol = Solution()
root = TreeNode(10)
root.left = TreeNode(1)
root.right = TreeNode(20)
root.left.left = TreeNode(-3)
# root.right.right = TreeNode(50)
print sol.rightSideView(root)