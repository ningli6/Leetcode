'''
Consider that each time a new added charater may increase the longest palindrome by 1 or 2,
We can just check if the new substring is a palindrome. This can be faster in practice
because string equality with '==' is amortized O(1)
'''

class Solution:
    # @param {string} s
    # @return {string}
    def longestPalindrome(self, s):
    	if not s or len(s) == 1:
    		return s
    	maxLen = -1
    	start, end = 0, 0
    	for i in range(len(s)):
    		if i - maxLen - 1 >= 0 and s[i - maxLen - 1: i + 1] == s[i - maxLen - 1: i + 1][::-1]:
    			start = i - maxLen - 1
    			end = i + 1
    			maxLen += 2
    		if i - maxLen >= 0 and s[i - maxLen: i + 1] == s[i - maxLen: i + 1][::-1]:
    			start = i - maxLen
    			end = i + 1
    			maxLen += 1
    	return s[start: end]

sol = Solution()
print sol.longestPalindrome('aba')