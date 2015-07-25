class Solution:
    # @param {integer[]} candidates
    # @param {integer} target
    # @return {integer[][]}
    def combinationSum2(self, candidates, target):
        if not candidates:
        	return []
        candidates.sort() # sort the array
        print candidates
        return self.bt(candidates, target) # backtracing

    def bt(self, nums, target):
        print nums, target
        result = []
        for x in range(len(nums)):
            if x > 0 and nums[x] == nums[x - 1]:
                continue
            # if sum is too large
            if target - nums[x] < 0:
                print 'too large'
                return result
            # if match
            if target - nums[x] == 0:
                result.append([nums[x]])
                print 'match'
                return result
            re = self.bt(nums[x + 1:], target - nums[x])
            if re:
                for lst in re:
                    lst.insert(0, nums[x])
                    print 'insert', nums[x]
                result.append(lst)
        return result

sol = Solution()
t= [10,1,2,7,6,1,5]
print sol.combinationSum2(t, 8)
