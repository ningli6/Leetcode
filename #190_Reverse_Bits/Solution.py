class Solution(object):
    def reverseBits(self, n):
    	re = 0
    	for x in range(32):
    		if n & 1 << x:
    			re |= 1 << (31 - x)
    	return re

sol = Solution()
print sol.reverseBits(0)