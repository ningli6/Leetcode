'''
Sieve of Eratosthenes
Space: O(n), time O(n * log(log(n)))
'''

class Solution(object):
    def countPrimes(self, n):
    	isPrime = [True for x in range(n)]
    	i = 2
    	while i * i < n:
    		if isPrime[i]:
    			j = i * i
    			while j < n:
    				isPrime[j] = False
    				j += i
    		i += 1
    	count = 0
    	for x in range(2, n):
    		if isPrime[x]:
    			count += 1
    	return count

sol = Solution()
print sol.countPrimes(5)