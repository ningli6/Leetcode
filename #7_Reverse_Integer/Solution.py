class Solution:

    def reverse(self, x):
        if x == 0:
        	return x
        re = 0
        t = abs(x)
        while t:
        	re = 10 * re + t - t / 10 * 10
        	t /= 10
        	if x > 0 and re > 2147483647:
        		return 0
        	if x < 0 and re > 2147483648:
        		return 0
        if x < 0:
        	return -1 * re
        return re

sol = Solution()
print sol.reverse(-123)