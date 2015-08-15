class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
		zeroBit, oneBit = 0, 0
		for n in nums:
			zeroBit = (zeroBit ^ n) & ~oneBit
			oneBit = (oneBit ^ n) & ~zeroBit
		return zeroBit

sol = Solution()
print sol.singleNumber([1, 1, 1, 3, 3, 3])