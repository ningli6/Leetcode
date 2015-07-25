class Solution:
	# @param {string} s
	# @return {boolean}
	def isValid(self, s):
		if not s:
			return True
		stk = []
		dict = {')': '(', '}': '{', ']': '['}
		for c in s:
			if c == '(' or c == '{' or c == '[':
				stk.append(c)
			else:
				if not stk or stk.pop() != dict[c]:
					return False
		return not stk

sol = Solution()
print sol.isValid("(")