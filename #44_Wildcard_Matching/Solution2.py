'''
Greedy solution, need back trace
Still O(m * n) worst case, but best is O(m + n)
'''

class Solution:
	# @param {string} s
	# @param {string} p
	# @return {boolean}
	def isMatch(self, s, p):
		if not s and not p: # both empty
			return True
		if not p: # empty pattern
			return False
		if not s: # empty string
			for c in p:
				if c != '*':
					return False
			return True
		# both s and p are not empty
		i, j = 0, 0
		ibt, jbt = 0, -1
		while i < len(s):
			if j < len(p) and (s[i] == p[j] or p[j] == '?'): # match
				i += 1
				j += 1
				continue
			if j < len(p) and p[j] == '*': # find star
				ibt = i # postion of i when compared to star
				jbt = j # postion of star
				j += 1
				continue
			if jbt >= 0: # not a match, not a star, but has prev star
				ibt += 1
				i = ibt
				j = jbt + 1
				continue
			return False # not a match, not a star, has no prev star
		for x in range(j, len(p)):
			if p[x] != '*':
				return False
		return True

sol = Solution()
print sol.isMatch("a", "a*")