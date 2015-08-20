class Solution:
    # @param {integer} n
    # @return {integer}
    def trailingZeroes(self, n):
        count = 0
        divisor = 5
        while n / divisor > 0:
        	count += n / divisor
        	divisor *= 5
        return count

sol = Solution()
print sol.trailingZeroes(25)