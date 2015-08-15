'''
Perform binary search on both columns and rows
time: O(log(rows) + log(cols))
'''

class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]:
        	return False
        row = self.binarySearch([matrix[x][0] for x in range(len(matrix))], target)
        if row < 0:
        	return False
        col = self.binarySearch(matrix[row], target)
        if col < 0:
        	return False
        return matrix[row][col] == target

    def binarySearch(self, nums, target):
    	lo, hi = 0, len(nums) - 1
    	while lo <= hi:
    		mid = lo + (hi - lo) / 2
    		if nums[mid] == target:
    			return mid
    		if nums[mid] < target:
    			lo = mid + 1
    		else:
    			hi = mid - 1
    	return hi

sol = Solution()
t = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print sol.searchMatrix(t, 10)