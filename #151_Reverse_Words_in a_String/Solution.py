class Solution:
	# @param s, a string
	# @return a string
	def reverseWords(self, s):
		if not s:
			return s
		re = []
		for w in reversed(s.split()):
			re.append(w)
			re.append(' ')
		return ''.join(re).rstrip()

sol = Solution()
print sol.reverseWords("the sky is blue")