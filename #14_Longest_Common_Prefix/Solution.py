'''
1) "Horizontal matching (over strings)". 
Pick up the first string and compare it with the rest. Return the minimum prefix found among all comparisons.

2) "Vertical matching (over characters)". 
Compare the characters between all strings from left to right. Stop whenever a mismatch is found.

Second one is faster because it is faster to fail.
Worst case time complexity is the same. O(n * m) where n is the length of array and m is average strlen
'''

class Solution:
    # @param {string[]} strs
    # @return {string}
    def longestCommonPrefix(self, strs):
        if not strs:
        	return ''
        lcp = 0
        while lcp < len(strs[0]):
        	for i in range(1, len(strs)):
        		if lcp >= len(strs[i]) or strs[0][lcp] != strs[i][lcp]:
        			return strs[0][:lcp]
        	lcp += 1
        return strs[0]

sol = Solution()
strs = ["abc", "ab", "abcde"]
print sol.longestCommonPrefix(strs)