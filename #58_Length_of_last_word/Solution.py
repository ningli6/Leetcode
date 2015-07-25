class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLastWord(self, s):
        if not s:
        	return 0
        s = s.split()
        if not s:
        	return 0
        return len(s[len(s) - 1])

sol = Solution()
print sol.lengthOfLastWord("Hello world")
