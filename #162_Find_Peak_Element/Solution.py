'''
O(log(n)) time
'''

class Solution:
    # @param nums, an integer[]
    # @return an integer
    def findPeakElement(self, nums):
        if not nums:
        	return -1
        return self.findPeak(nums, 0, len(nums) - 1)

    def findPeak(self, nums, lo, hi):
    	if lo == hi:
    		return lo
    	mid = lo + (hi - lo) / 2
    	if nums[mid] > nums[mid + 1]:
    		return self.findPeak(nums, lo, mid)
    	return self.findPeak(nums, mid + 1, hi)

sol = Solution()
print sol.findPeakElement([5, 4, 3, 2, 1])