class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def majorityElement(self, nums):
    	major = 0
    	count = 0
    	for n in nums:
    		if count == 0:
    			major = n
    		if n == major:
    			count += 1
    		else:
    			count -= 1
    	return major

sol = Solution()
print sol.majorityElement([1, 2, 3, 1, 1])