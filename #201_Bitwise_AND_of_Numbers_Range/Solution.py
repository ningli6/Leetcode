'''
Result of bitwise and of all numbers in the range [m, n] is the common part of their left bit
So we don't need to check all numbers in the range, we can only check the common part of m and n
'''

class Solution(object):
    def rangeBitwiseAnd(self, m, n):
    	if m == 0:
    		return 0
    	count = 0
    	while m != n:
    		m >>= 1
    		n >>= 1
    		count += 1
    	return m << count

sol = Solution()
print sol.rangeBitwiseAnd(3, 5)