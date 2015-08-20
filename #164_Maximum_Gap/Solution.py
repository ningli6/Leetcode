class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maximumGap(self, nums):
        if not nums or len(nums) < 2:
        	return 0
        maxVal = max(nums)
        minVal = min(nums)
        diff = max((maxVal - minVal) / (len(nums) - 1), 1)
        minBucket = [-1 for x in range((maxVal - minVal) / diff + 1)]
        maxBucket = [-1 for x in range((maxVal - minVal) / diff + 1)]
        for n in nums:
        	ind = (n - minVal) / diff
        	if minBucket[ind] == -1:
        		minBucket[ind] = n
        	else:
        		minBucket[ind] = min(minBucket[ind], n)
        	if maxBucket[ind] == -1:
        		maxBucket[ind] = n
        	else:
        		maxBucket[ind] = max(maxBucket[ind], n)
        maxGap = 0
        x = 0
        prev = 0
        while x < len(minBucket):
        	if maxBucket[x] != -1:
        		prev = x
        		x += 1
        		break
        	x += 1
        while x < len(minBucket):
        	if minBucket[x] == -1:
        		x += 1
        		continue
        	maxGap = max(minBucket[x] - maxBucket[prev], maxGap)
        	prev = x
        	x += 1
        return maxGap

sol = Solution()
print sol.maximumGap([1,1,1,1,1,5,5,5,5,5])