'''
time: O(n * n ^0.5)
'''

class Solution(object):
    def countPrimes(self, n):
    	count = 0
    	for x in range(2, n):
    		if self.isPrime(x):
    			count += 1
    	return count

    def isPrime(self, n):
    	if n <= 1:
    		return False
    	i = 2
    	while i * i <= n:
    		if n % i == 0:
    			return False
    		i += 1
    	return True

sol = Solution()
print sol.countPrimes(3)