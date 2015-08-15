class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
        sum = 0
    	for n in nums:
    		sum ^= n
        return sum

sol = Solution()
print sol.singleNumber([-1])