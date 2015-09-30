class Solution(object):
	# @Param input: String
	# @Return List[int]
	def diffWaysToCompute(self, input):
		if not input:
			return []
		re = []
		for i in range(len(input)):
			if input[i] == '+' or input[i] == '-' or input[i] == '*':
				left = self.diffWaysToCompute(input[0:i])
				right = self.diffWaysToCompute(input[i + 1:])
				for lnum in left:
					for rnum in right:
						if input[i] == '+':
							re.append(lnum + rnum)
						elif input[i] == '-':
							re.append(lnum - rnum)
						else:
							re.append(lnum * rnum)
		if not re:
			re.append(int(input))
		return re

sol = Solution()
print sol.diffWaysToCompute('2-1-1')