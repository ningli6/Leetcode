class Solution:
    # @param {string} s
    # @return {integer}
    def longestValidParentheses(self, s):
        if not s or len(s) < 2:
        	return 0
        dp = [0 for x in range(len(s))] # longest valid parentheses that end with i
        for i in range(1, len(s)):
        	if s[i] == '(':
        		continue
        	if i - dp[i - 1] * 2 - 1 >= 0 and s[i - dp[i - 1] * 2 - 1] == '(':
        		dp[i] = dp[i - 1] + 1
        		if i - dp[i - 1] * 2 - 2 >= 0:
        			dp[i] += dp[i - dp[i - 1] * 2 - 2]
        return max(dp) * 2

sol = Solution()
print sol.longestValidParentheses("()")