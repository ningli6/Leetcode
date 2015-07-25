class Solution:
    # @param {float} x
    # @param {integer} n
    # @return {float}
    def myPow(self, x, n):
        if x == 0:
        	return 0
        if n == 0:
        	return 1
        if n == 1:
        	return x
        if n < 0:
        	return 1 / self.myPow(x, -n)
    	val = self.myPow(x, n / 2)
        if n & 1:
        	return val * val * x
        return val * val


sol = Solution()
print sol.myPow(2, 10)