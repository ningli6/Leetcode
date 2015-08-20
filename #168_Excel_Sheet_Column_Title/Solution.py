class Solution:
    # @param {integer} n
    # @return {string}
    def convertToTitle(self, n):
    	R = 26
        re = ''
        while n > 0:
        	[n, r] = divmod(n - 1, R)
        	re += chr(ord('A') + r)
        return re[::-1]

sol = Solution()
print sol.convertToTitle(29)