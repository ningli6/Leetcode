class Solution(object):
    def isHappy(self, n):
    	computed = set()
    	while n != 1:
    		if n in computed:
    			return False
    		computed.add(n)
    		n = self.transform(n)
    	return True

    def transform(self, n):
    	re = 0
    	while n > 0:
    		[n, r] = divmod(n, 10)
    		re += r * r
    	return re

sol = Solution()
print sol.isHappy(20)