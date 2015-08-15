class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    def sortColors(self, nums):
        if not nums or len(nums) < 2:
        	return
        i, j = 0, len(nums) - 1
        cur = i
        while cur <= j: #
        	if nums[cur] == 0:
        		self.swap(nums, cur, i)
        		cur += 1
        		i += 1
        	elif nums[cur] == 2:
        		self.swap(nums, cur, j)
        		j -= 1
        	else:
        		cur += 1

    def swap(self, nums, i, j):
    	if not nums:
    		return
    	if i == j:
    		return
    	tmp = nums[j]
    	nums[j] = nums[i]
    	nums[i] = tmp

sol = Solution()
t = [2, 0, 0]
sol.sortColors(t)
print t