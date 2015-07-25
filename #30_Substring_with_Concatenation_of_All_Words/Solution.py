class Solution:
	# @param {string} s
	# @param {string[]} words
	# @return {integer[]}
	def findSubstring(self, s, words):
		if not s or not words:
			return []
		re = []
		map = {}
		for word in words:
			map[word] = map.get(word, 0) + 1
		wlen = len(words[0])
		window = {}
		for x in range(wlen):
			i = x
			j = x
			while j + wlen <= len(s):
				sub = s[j:j + wlen]
				j += wlen
				if sub in map:
					window[sub] = window.get(sub, 0) + 1
				else:
					i = j
					window.clear()
				if j - i == wlen * len(words):
					if window == map:
						re.append(i)
					delStr = s[i: i + wlen]
					window[delStr] = window[delStr] - 1
					if window[delStr] == 0:
						del window[delStr]
					i += wlen
			window.clear()
		return re


sol = Solution()
print sol.findSubstring("barfoothefoobarman", ["foo", "bar"])
