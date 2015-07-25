'''
Implement KMP algorithm for substring search
Time complexity: O(m + n), space O(m), no backup needed
'''

class KMP:
	# @param {string} pattern
	# @return {integer[]}
	def getNext(self, pattern):
		if not pattern:
			return []
		next = [0 for i in range(len(pattern))]
		next[0] = -1
		if len(pattern) < 3:
			return next[:len(pattern)]
		for x in range(2, len(pattern)):
			if pattern[x - 1] == pattern[next[x - 1]]:
				next[x] = next[x - 1] + 1
			else:
				k = next[x - 1]
				while k >= 0 and pattern[x - 1] != pattern[k]:
					k = next[k]
				next[x] = k + 1
		return next

	# @param {string} text string
	# @param {string} pattern string
	# @return {boolean}
	def isSubstring(self, haystack, pattern):
		if not haystack and not pattern:
			return True
		if not haystack and pattern:
			return False
		if haystack and not pattern:
			return True
		next = self.getNext(pattern)
		i, j = 0, 0
		while i < len(haystack) and j < len(needle):
			if haystack[i] == pattern[j] or j == -1:
				i += 1
				j += 1
			else:
				j = next[j]
			if j == len(pattern):
				return True
		return False

	# @param {string} haystack
	# @param {string} needle
	# @return {integer}
	def strStr(self, haystack, needle):
		if not haystack and not needle:
			return 0
		if not haystack and needle:
			return -1
		if haystack and not needle:
			return 0
		if len(haystack) < len(needle):
			return -1
		next = self.getNext(needle)
		i, j = 0, 0
		while i < len(haystack) and j < len(needle):
			if haystack[i] == needle[j] or j == -1:
				i += 1
				j += 1
			else:
				j = next[j]
		if j == len(needle):
			return i - j
		return -1

kmp = KMP()
s = 'aaa'
p = 'aaa'
print kmp.getNext(p)
print kmp.strStr(s, p)