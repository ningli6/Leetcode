'''
Use time sort
time: O(n log(n)) worst, O(n) best
space: O(n log(n)) average, O(n) worst
'''

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        return nums[len(nums) - k]

sol = Solution()
print sol.findKthLargest([1, 2, 3, 4], 4)