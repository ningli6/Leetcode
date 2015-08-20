class Solution:
    # @param {string} s
    # @return {integer}
    def titleToNumber(self, s):
        ans = 0
        for c in s:
        	ans = ans * 26 + ord(c) - ord('A') + 1
        return ans

sol = Solution()
print sol.titleToNumber("AA")