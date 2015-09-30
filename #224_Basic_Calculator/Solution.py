class Solution(object):
	def calculate(self, s):
		"""
		:type s: str
		:rtype: int
		"""
		if not s:
			return 0
		stack = []
		i = 0
		while i < len(s):
			if s[i] == '(' or s[i] == '+' or s[i] == '-':
				stack.append(s[i])
			elif s[i].isdigit():
				j = i
				while j + 1 < len(s) and s[j + 1].isdigit():
					j += 1
				stack.append(int(s[i:j + 1]))
				i = j
			elif s[i] == ')':
				sum = 0
				while stack:
					val = stack.pop()
					if not stack:
						sum += val
					else:
						char = stack.pop()
						if char == '+':
							sum += val
						if char == '-':
							sum -= val
						if char == '(':
							sum += val
							break
				stack.append(sum)
			i += 1
		sum = 0
		while stack:
			val = stack.pop()
			if not stack:
				sum += val
			else:
				char = stack.pop()
				if char == '+':
					sum += val
				if char == '-':
					sum -= val
		return sum

sol = Solution()
print sol.calculate("(1+(4+5+2)-3)+(6+8)")