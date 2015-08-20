class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstringTwoDistinct(self, s):
        if not s:
        	return 0
        wrdCount = {}
        i, j = 0, 0
        re = 0
        while j < len(s):
        	if len(wrdCount) < 2 or s[j] in wrdCount:
        		wrdCount[s[j]] = wrdCount.get(s[j], 0) + 1
        		j += 1
        		re = max(re, j - i)
        	else:
        		wrdCount[s[i]] -= 1
        		if wrdCount[s[i]] == 0:
        			del wrdCount[s[i]]
        		i += 1
        return re

sol = Solution()
print sol.lengthOfLongestSubstringTwoDistinct("ab")