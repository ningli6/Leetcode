'''
O(n ^ 2) time Solution
'''

class Solution:
    # @param s, a string
    # @param wordDict, a set<string>
    # @return a boolean
    def wordBreak(self, s, wordDict):
        if not wordDict:
        	return False
        dp = [False for x in range(len(s) + 1)]
        dp[0] = True
        for j in range(len(s)):
        	for i in range(j + 1):
        		if s[i : j + 1] in wordDict and dp[i]:
        			dp[j + 1] = True
        return dp[len(s)]

sol = Solution()
wd = set(['leet', 'code'])
print sol.wordBreak('leetcode', wd)