class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def findMin(self, nums):
        if len(nums) == 1:
        	return nums[0]
        if len(nums) == 2:
        	return min(nums)
        if nums[0] < nums[len(nums) - 1]:
        	return nums[0]
        mid = (len(nums) - 1) / 2
        if nums[mid] > nums[0]: # left is sorted, search right
        	return self.findMin(nums[mid + 1:])
        if nums[mid] < nums[0]: # left is unsorted, search left
        	return self.findMin(nums[:mid + 1])
        if nums[mid] < nums[len(nums) - 1]: # right is sorted, search left
            return self.findMin(nums[:mid + 1])
        if nums[mid] > nums[len(nums) - 1]:# right is un sorted, search right
            return self.findMin(nums[mid + 1:])
        return self.findMin(nums[1:])

sol = Solution()
print sol.findMin([1, 1, 2, 2, 2, 0])