'''
DFS solution need to compute height first, use bfs here
'''

from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def levelOrderBottom(self, root):
        if not root:
        	return []
        ans = deque()
        queue = deque([root])
        while queue:
        	integers = []
        	for x in range(len(queue)):
        		node = queue.popleft()
        		integers.append(node.val)
        		if node.left:
        			queue.append(node.left)
        		if node.right:
        			queue.append(node.right)
        	ans.appendleft(integers)
        return ans

sol = Solution()
root = TreeNode(0)
nd1 = TreeNode(1)
nd2 = TreeNode(2)
nd3 = TreeNode(3)
nd4 = TreeNode(4)
root.left = nd1
root.right = nd2
nd1.left = nd3
nd2.left = nd4
print sol.levelOrderBottom(root)