class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    def nextPermutation(self, nums):
        if not nums or len(nums) < 2:
        	return
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
        	i -= 1
        if i < 0:
        	self.reverse(nums, 0)
        	return
        j = i
        while j + 1 < len(nums) and nums[j + 1] > nums[i]:
        	j += 1
        self.swap(nums, i, j)
        self.reverse(nums, i + 1)

    def swap(self, nums, i, j):
    	if not nums:
    		return
    	if i < 0 or j < 0 or i >= len(nums) or j >= len(nums):
    		return
    	tmp = nums[i]
    	nums[i] = nums[j]
    	nums[j] = tmp

    def reverse(self, nums, i):
    	if not nums:
    		return
    	if i < 0 or i >= len(nums) - 1:
    		return
    	j = len(nums) - 1
    	while i < j:
    		self.swap(nums, i, j)
    		i += 1
    		j -= 1


sol = Solution()
t = [3, 2, 1]
# sol.reverse(t, 0)
sol.nextPermutation(t)
print t