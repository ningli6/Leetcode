class Solution(object):
    def countDigitOne(self, n):
        ones = 0
        m = 1
        while n / m:
        	a = n / m
        	b = n % m
        	if a % 10 == 0:
        		ones += a / 10 * m
        	elif a % 10 == 1:
        		ones += a / 10 * m + b + 1
        	else:
        		ones += a / 10 * m + m
        	m *= 10
        return ones

sol = Solution()
print sol.countDigitOne(10)