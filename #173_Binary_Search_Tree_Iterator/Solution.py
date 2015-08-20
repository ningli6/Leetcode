# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator:
    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.stack = []
        self.pushLeftPath(root)

    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        return bool(self.stack)

    # @return an integer, the next smallest number
    def next(self):
        node = self.stack.pop()
        self.pushLeftPath(node.right)
        return node.val

    def pushLeftPath(self, root):
    	while root:
    		self.stack.append(root)
    		root = root.left

# Your BSTIterator will be called like this:
root = TreeNode(5)
root.left = TreeNode(1)
root.right = TreeNode(10)
root.right.left = TreeNode(7)
root.right.right = TreeNode(12)
root.left.left = TreeNode(0)
root.left.right = TreeNode(3)
i, v = BSTIterator(root), []
while i.hasNext(): 
	v.append(i.next())
print v