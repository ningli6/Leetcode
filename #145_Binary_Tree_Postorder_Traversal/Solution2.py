'''
Iterative solution using explict stack
The difficulty with post order traversal is that,
you can't simple pop root node each time,
instead, push right branch in the stack.
So when pop again, how do you know if the node has been visited before?
Use another pointer lastNode in this case. 
For example if node.right is lastNode, then it means node has finished its both branch
and can be popped therefore.
'''
class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:

	# @param {TreeNode} root
	# @return {integer[]}
	def postorderTraversal(self, root):
		re = []
		stack = []
		node = root
		lastNode = None
		while node or stack:
			if node:
				stack.append(node)
				node = node.left
			else:
				tmp = stack[len(stack) - 1]
				if tmp.right and (tmp.right is not lastNode):
					node = tmp.right
				else:
					re.append(tmp.val)
					stack.pop()
					lastNode = tmp
		return re