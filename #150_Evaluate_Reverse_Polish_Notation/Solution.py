class Solution:
	# @param {string[]} tokens
	# @return {integer}
	def evalRPN(self, tokens):
		if not tokens or len(tokens) == 2:
			return 0
		if len(tokens) == 1:
			try:
				return int(tokens[0])
			except Exception, e:
				return 0
		stack = []
		for t in tokens:
			if t == '+':
				stack.append(stack.pop() + stack.pop())
			elif t == '-':
				i = stack.pop()
				j = stack.pop()
				stack.append(j - i)
			elif t == '*':
				stack.append(stack.pop() * stack.pop())
			elif t == '/':
				i = stack.pop()
				j = stack.pop()
				re = abs(j) / abs(i)
				if i * j < 0:
					re = -re
				stack.append(re)
			else:
				stack.append(int(t))
		return stack[0]

sol = Solution()
print sol.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"])