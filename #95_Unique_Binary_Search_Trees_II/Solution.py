class TreeNode:
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None

class Solution:
	# @param {integer} n
	# @return {TreeNode[]}
	def generateTrees(self, n):
		return self.generate([x for x in range(1, n + 1)])

	def generate(self, nums):
		if not nums:
			return [None]
		re = []
		for x in range(len(nums)):
			leftNodes = self.generate(nums[:x])
			rightNodes = self.generate(nums[x + 1:])
			for l in leftNodes:
				for r in rightNodes:
					node = TreeNode(nums[x])
					node.left = l
					node.right = r
					re.append(node)
		return re