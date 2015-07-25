'''
Brute force O(n * m)
'''

class Solution:
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
		if haystack and needle and len(haystack) < len(needle):
			return -1
		for x in range(len(haystack) - len(needle) + 1):
			i = x
			j = 0
			while j < len(needle) and haystack[i] == needle[j]:
				j += 1
				i += 1
			if j == len(needle):
				return x
		return -1