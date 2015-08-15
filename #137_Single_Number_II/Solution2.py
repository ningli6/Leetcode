class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
    	x1 = 0
    	x2 = 0
    	mask = 0
    	for i in nums:
    		x2 ^= x1 & i
    		x1 ^= i
    		mask = ~(x2 & x1) # k = 11
    		x2 &= mask
    		x1 &= mask
    	return x2 # p = 10

sol = Solution()
print sol.singleNumber([1, 1, 1, 3, 3, 3, 4, 4])