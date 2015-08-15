class Solution:
    # @param {integer} n
    # @param {integer} k
    # @return {integer[][]}
    def combine(self, n, k):
        if k < 1:
        	return []
        tmp = []
        ans = []
        self.bt(1, n, k, tmp, ans)
        return ans

    def bt(self, s, e, k, tmp, ans):
    	if k == 0:
    		ans.append(list(tmp)) # hard copy
    		return
    	if e - s + 1 < k:
    		return
    	for x in range(s, e + 1):
    		tmp.append(x)
    		self.bt(x + 1, e, k - 1, tmp, ans)
    		tmp.pop()

sol = Solution()
print sol.combine(4, 2)