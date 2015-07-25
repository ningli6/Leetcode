class Solution:
    # @param {integer} n
    # @return {string[]}
    def generateParenthesis(self, n):
        if n < 1:
        	return ''
        lp = n   # number of left parenthesis that can be plotted
        rp = n   # number of right parenthesis that can be plotted
        re = []
        self.gp(re, lp, rp, '')
        return re

    def gp(self, result, lp, rp, str):
    	if lp == 0 and rp == 0:
    		result.append(str)
    	if lp > rp:
    		return
    	if lp > 0:
    		self.gp(result, lp - 1, rp, str + '(')
    	if rp > 0:
    		self.gp(result, lp, rp - 1, str + ')')


sol = Solution()
re = sol.generateParenthesis(3)
print re