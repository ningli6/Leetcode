class Solution:
    # @param {integer[]} numbers
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, numbers, target):
        if not numbers or len(numbers) < 2:
        	return []
        i, j = 0, len(numbers) - 1
        while i < j:
        	if numbers[i] + numbers[j] == target:
        		return [i + 1, j + 1] # 1 based
        	elif numbers[i] + numbers[j] > target:
        		j -= 1
        	else:
        		i += 1
        return []

sol = Solution()
print sol.twoSum([2, 7, 11, 15], 9)