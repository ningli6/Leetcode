'''
Implement Boyer-Moore algorithm for substring search
Time: O(n / m), worst can be O(m * n), space O(R)
Needs backup
'''

class BoyerMoore:
	def strStr(self, haystack, needle):
		if not haystack and not needle:
			return 0
		if not haystack and needle:
			return -1
		if haystack and not needle:
			return 0
		if len(haystack) < len(needle):
			return -1
		R = 26
		right = [-1 for x in range(R)]
		for index, char in enumerate(needle):
			right[ord(char) - ord('a')] = index
		i = 0
		while i < len(haystack) - len(needle) + 1:
			j = len(needle) - 1
			while j >= 0 and haystack[i + j] == needle[j]:
				j -= 1
			if j < 0:
				return i
			i += max(1, j - right[ord(haystack[i + j]) - ord('a')])
		return -1

sol = BoyerMoore()
s = 'abcdefg'
p = 'de'
print sol.strStr(s, p)