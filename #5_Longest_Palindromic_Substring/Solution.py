'''
Seems that O(n ^ 2) is the best algorithm we can get

Solution below uses iterative approach
'''

class Solution:
    # @param {string} s
    # @return {string}
    def longestPalindrome(self, s):
    	if not s or len(s) == 1:
    		return s
    	start, end, maxLen = -1, -1, 0
    	for x in range(len(s)):
    		i = x - 1
    		j = x + 1
    		while j < len(s) and s[j] == s[x]:
    			j += 1
    		while i >= 0 and j < len(s) and s[i] == s[j]:
    			i -= 1
    			j += 1
    		if j - i - 1 > maxLen:
    			start, end, maxLen = i + 1, j, j - i - 1
    	return s[start: end]

sol = Solution()
print sol.longestPalindrome('a')