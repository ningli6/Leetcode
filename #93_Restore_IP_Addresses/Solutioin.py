'''
Special case:
010
001
01
leading 0s
'''

class Solution:

	def __init__(self):
		self.re = None
		self.tmp = None

	# @param {string} s
	# @return {string[]}
	def restoreIpAddresses(self, s):
		if not s or len(s) < 4:
			return []
		self.re = []
		self.tmp = []
		self.appendIP(s, 4)
		return self.re

	def appendIP(self, s, k):
		if not s or k == 0:
			return
		for x in range(1, min(4, len(s) + 1)):
			if x > 1 and s[0] == '0':
				return
			if int(s[:x]) > 255:
				return
			self.tmp.append(s[:x])
			if not s[x:] and k == 1:
				self.re.append(''.join(self.tmp))
			self.tmp.append('.')
			self.appendIP(s[x:], k - 1)
			self.tmp.pop()
			self.tmp.pop()

sol = Solution()
print sol.restoreIpAddresses("010010")