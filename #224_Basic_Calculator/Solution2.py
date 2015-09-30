class Solution(object):
	def calculate(self, s):
		"""
		:type s: str
		:rtype: int
		"""
		if not s:
			return 0
		stack = []
		re = 0
		num = 0
		sign = 1 # 1 for +, -1 for -
		for c in s:
			if c.isdigit():
				num = num * 10 + ord(c) - ord('0')
			elif c == '+':
				re += num * sign
				num = 0
				sign = 1
			elif c == '-':
				re += num * sign
				num = 0
				sign = -1
			elif c == '(':
				stack.append(re)
				stack.append(sign)
				re = 0
				num = 0
				sign = 1
			elif c == ')':
				re += num * sign
				re *= stack.pop()
				re += stack.pop()
				num = 0
				sign = 1
		return re + num * sign

sol = Solution()
print sol.calculate("(1+(4+5+2)-3)+(6+8)")