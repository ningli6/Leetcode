'''
Similar idea like rabin-karp, hash a sequence of string in averge O(1) time
Use 20 bit to represent a number, a - 00, c - 01, g - 10, t - 11

The algorithm runs in O(n) time
'''

class Solution(object):
	def findRepeatedDnaSequences(self, s):
		if not s or len(s) < 10:
			return []
		dict = {}
		re = []
		hs = self.hash10(s[0:10])
		dict[hs] = 1
		j = 10
		while j < len(s):
			hs = self.rollingHash(hs, s[j])
			if hs not in dict:
				dict[hs] = 1
			elif dict[hs] == 1:
				re.append(s[j - 9:j + 1])
				dict[hs] = 2
			j += 1
		return re

	def hash10(self, s):
		hs = 0
		for x in range(10):
			hs <<= 2
			if s[x] == 'C':
				hs |= 1
			elif s[x] == 'G':
				hs |= 2
			elif s[x] == 'T':
				hs |= 3
		return hs

	def rollingHash(self, hsval, newChar):
		hsval <<= 2
		hsval &= ~(3 << 20)
		if newChar == 'C':
			hsval |= 1
		elif newChar == 'G':
			hsval |= 2
		elif newChar == 'T':
			hsval |= 3
		return hsval

sol = Solution()
s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
print sol.findRepeatedDnaSequences(s)
# print sol.hash10("AAAAACCCCC")