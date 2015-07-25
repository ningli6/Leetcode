class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def searchInsert(self, nums, target):
        if not nums:
        	return 0
        if target < nums[0]:
        	return 0
        if target > nums[len(nums) - 1]:
        	return len(nums)
        i, j, mid = 0, len(nums) - 1, 0
        while i <= j:
        	mid = i + (j - i) / 2
        	if nums[mid] == target:
        		return mid
        	elif nums[mid] > target:
        		j = mid - 1
        	else:
        		i = mid + 1
        return i

sol = Solution()
t = [1, 3, 5, 6]
print sol.searchInsert(t, 2)