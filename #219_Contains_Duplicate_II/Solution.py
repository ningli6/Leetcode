class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if not nums:
        	return False
        if k <= 0:
        	return False
        window = set()
        i, j = 0, 0
        while j <= k and j < len(nums):
        	if nums[j] in window:
        		return True
        	window.add(nums[j])
        	j += 1
        while j < len(nums):
        	window.remove(nums[i])
        	i += 1
        	if nums[j] in window:
        		return True
        	window.add(nums[j])
        	j += 1
        return False

sol = Solution()
print sol.containsNearbyDuplicate([1, 2, 1, 4, 5], 2)