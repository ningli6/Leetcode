class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstring(self, s):
    	if (not s) or len(s) == 0:
    		return 0
    	window = set()
    	maxLen, i, j = 0, 0, 0
    	while i < len(s) and j < len(s):
    		while i < len(s) and s[j] in window:
    			window.remove(s[i])
    			i += 1
    		while j < len(s) and s[j] not in window:
    			window.add(s[j])
    			j += 1
    		maxLen = max(maxLen, j - i)
    	return maxLen


sol = Solution()
print sol.lengthOfLongestSubstring("abcabcbb")

