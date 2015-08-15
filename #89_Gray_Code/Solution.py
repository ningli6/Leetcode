class Solution:
    # @param {integer} n
    # @return {integer[]}
    def grayCode(self, n):
        if n == 0:
        	return [0]
        if n == 1:
        	return [0, 1]
        re = self.grayCode(n - 1)
        for x in range((1 << n - 1) - 1, -1, -1):
        	re.append((1 << n - 1) + re[x])
        return re

sol = Solution()
print sol.grayCode(3)