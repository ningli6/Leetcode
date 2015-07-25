'''
Two pointer Solution O(nlog(n))

Since the question requires to return index, we need to use additional space to save position information
Not best fit for this problem
'''

class Num:
	def __init__(self, index, val):
		self.index = index
		self.val = val

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, nums, target):
    	# save index info
    	NumArray = [Num(x, nums[x]) for x in range(len(nums))]
    	# sort the array
    	NumArray.sort(key = lambda Num: Num.val)
    	# use two pointers
    	i, j = 0, len(NumArray) - 1
    	# see if they add up to target val
    	while NumArray[i].val + NumArray[j].val != target:
    		if NumArray[i].val + NumArray[j].val > target:
    			j -= 1
    		if NumArray[i].val + NumArray[j].val < target:
    			i += 1
    	re = [NumArray[i].index + 1, NumArray[j].index + 1]
    	return sorted(re)

nums = [3, 2, 4]
sol = Solution()
print sol.twoSum(nums, 6)