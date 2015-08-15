'''
Binary search
time: O(log(n))
'''

class Solution:
    # @param {integer} x
    # @return {integer}
    def mySqrt(self, x):
        if x == 0 or x == 1:
        	return x
        minVal = 1
        maxVal = x
        while minVal <= maxVal:
        	mid = minVal + (maxVal - minVal) / 2
        	if mid * mid == x:
        		return mid
        	elif mid * mid > x:
        		maxVal = mid - 1
        	else:
        		minVal = mid + 1
        return min(maxVal, minVal)

sol = Solution()
print sol.mySqrt(10)