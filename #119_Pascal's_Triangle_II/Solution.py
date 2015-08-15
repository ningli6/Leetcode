class Solution:
    # @param {integer} rowIndex
    # @return {integer[]}
    def getRow(self, rowIndex):
        if rowIndex < 0:
        	return []
        if rowIndex == 0:
        	return [1]
        if rowIndex == 1:
        	return [1, 1]
        prev = [1 for x in range(rowIndex + 1)]
        for x in range(2, rowIndex + 1):
        	tmp = 1
        	for y in range(1, x):
        		tmp2 = prev[y]
        		prev[y] = tmp + prev[y]
        		tmp = tmp2
        return prev

sol = Solution()
print sol.getRow(3)