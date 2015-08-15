'''
Time limit exceed
'''

class Solution:
	# @param {string} s1
	# @param {string} s2
	# @return {boolean}
	def isScramble(self, s1, s2):
		if not s1 and not s2:
			return True
		if not s1 or not s2:
			return False
		if len(s1) != len(s2):
			return False
		if s1 == s2:
			return True
		if sorted(s1) != sorted(s2):
			return False
		for x in range(1, len(s1)):
			if self.isScramble(s1[:x], s2[:x]) and self.isScramble(s1[x:], s2[x:]):
				return True
			if self.isScramble(s1[:x], s2[len(s2) - x:]) and self.isScramble(s1[x:], s2[:len(s2) - x]):
				return True
		return False

sol = Solution()
print sol.isScramble("great", "rgeat")