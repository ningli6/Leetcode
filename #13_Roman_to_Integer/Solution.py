class Solution:
    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        if not s:
        	return 0
        map = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
        re, i = 0, 0
        while i < len(s):
        	if i < len(s) - 1 and map[s[i + 1]] / map[s[i]] > 1:
        		re += map[s[i + 1]] - map[s[i]]
        		i += 2
        	else:
        		re += map[s[i]]
        		i += 1
        return re

sol = Solution()
print sol.romanToInt("XCVIII")