class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        re = [1 for i in range(len(nums))]
        product = 1
        for i in range(1, len(nums)):
        	product *= nums[i - 1]
        	re[i] *= product
        product = 1
        for i in range(len(nums) - 2, -1, -1):
        	product *= nums[i + 1]
        	re[i] *= product
        return re

sol = Solution()
print sol.productExceptSelf([1, 2, 3, 4])