class Solution(object):
    def hammingWeight(self, n):
    	count = 0
    	for x in range(32):
    		if n & 1 << x:
    			count += 1
    	return count

sol = Solution()
print sol.hammingWeight(2)