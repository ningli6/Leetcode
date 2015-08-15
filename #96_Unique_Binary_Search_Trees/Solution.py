'''
Time limit exceed
'''

class Solution:
    # @param {integer} n
    # @return {integer}
    def numTrees(self, n):
        if n < 1:
        	return 0
        return self.countTree([x for x in range(1, n + 1)])

    def countTree(self, nums):
    	if not nums:
    		return 1
    	ans = 0
    	for x in range(len(nums)):
    		ans += self.countTree(nums[:x]) * self.countTree(nums[x + 1:])
    	return ans

sol = Solution()
print sol.numTrees(3)