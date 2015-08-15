class Solution:
    # @param {integer} numRows
    # @return {integer[][]}
    def generate(self, numRows):
        if numRows < 1:
        	return []
        if numRows == 1:
        	return [[1]]
        if numRows == 2:
        	return [[1], [1, 1]]
        re = [[1], [1, 1]]
        for x in range(2, numRows):
        	tmp = [1 for k in range(x + 1)]
        	for y in range(1, len(tmp) - 1):
        		tmp[y] = re[x - 1][y - 1] + re[x - 1][y]
        	re.append(tmp)
        return re

sol = Solution()
print sol.generate(5)