'''
Exceed time limit
'''

class Solution:
    # @param {string} s
    # @return {integer}
    def numDecodings(self, s):
        if not s:
        	return 1
        oneNum = self.numDecodings(s[1:])
        twoNum = 0
        if len(s) > 1 and int(s[:2]) <= 26:
        	twoNum = self.numDecodings(s[2:])
        return oneNum + twoNum

sol = Solution()
print sol.numDecodings('129')