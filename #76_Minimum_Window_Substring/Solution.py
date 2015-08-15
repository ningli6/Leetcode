'''
1, when right bound meet a char in t, add it to window, always make sure that sliding window is valid,
2, then shrink left side as much as possible
3, compare length
'''

class Solution:
	# @param {string} s
	# @param {string} t
	# @return {string}
	def minWindow(self, s, t):
		if not t or not s:
			return ''
		map = {}
		for c in t:
			map[c] = map.get(c, 0) + 1
		window = {}
		i, j, match = 0, 0, 0
		minL = len(s)
		ans = ''
		while j < len(s):
			if s[j] not in map:
				j += 1    # extend right bound
				continue
			window[s[j]] = window.get(s[j], 0) + 1 # add it to window
			if window[s[j]] <= map[s[j]]:
				match += 1
			j += 1
			while i < j:  # shrink left bound
				if s[i] not in map:
					i += 1
				elif window[s[i]] > map.get(s[i]):
					window[s[i]] = window[s[i]] - 1
					i += 1
				else:
					break
			if match == len(t):  # see if it's a match
				l = j - i
				if l <= minL: #
					minL = l  #
					ans = s[i:j]
		return ans

sol = Solution()
s = "ABBC"
t = "ABC"
print sol.minWindow(s, t)