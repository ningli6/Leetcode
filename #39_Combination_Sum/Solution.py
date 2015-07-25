class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}
    def combinationSum(self, candidates, target):
        if not candidates:
        	return []
        candidates.sort()
        return self.bt(candidates, target)


    def bt(self, candidates, target):
    	if not candidates:
        	return []
        result = []
        sum = 0
        c = 0
        while sum <= target:
        	init = [candidates[0] for x in range(c)]
        	if target == sum:
        		result.append(init)
        	else:    		
	        	re = self.combinationSum(candidates[1:], target - sum)
	        	if re:
	        		for list in re:
		        		result.append(init + list)
        	sum += candidates[0]
        	c += 1
        return result

sol = Solution()
print sol.combinationSum([2, 3, 6, 7], 7)