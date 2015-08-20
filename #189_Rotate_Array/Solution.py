class Solution(object):
    def rotate(self, nums, k):
    	if not nums or len(nums) < 2:
    		return
    	k %= len(nums)
    	if k <= 0:
    		return
    	self.reverse(nums, 0, len(nums) - 1)
    	self.reverse(nums, 0, k - 1)
    	self.reverse(nums, k, len(nums) - 1)

    def reverse(self, nums, start, end):
    	if not nums or len(nums) == 1:
    		return
    	i, j = start, end
    	while i <= j:
    		tmp = nums[i]
    		nums[i] = nums[j]
    		nums[j] = tmp
    		i += 1
    		j -= 1

sol = Solution()
t = [1,2,3,4,5,6,7]
sol.rotate(t, 3)
print t