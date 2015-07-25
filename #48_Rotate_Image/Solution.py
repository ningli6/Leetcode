class Solution:
    # @param {integer[][]} matrix
    # @return {void} Do not return anything, modify matrix in-place instead.
    def rotate(self, matrix):
        if not matrix or len(matrix) == 1:
        	return
        n = len(matrix)
        for x in range(n / 2):
        	for y in range(x, n - 1 - x):
        		i, j = x, y
        		a = matrix[i][j]
        		b = matrix[j][n - 1 - i]
        		c = matrix[n - 1 - i][n - 1 - j]
        		d = matrix[n - 1 - j][i]
        		matrix[i][j] = d
        		matrix[j][n - 1 - i] = a
        		matrix[n - 1 - i][n - 1 - j] = b
        		matrix[n - 1 - j][i] = c

sol = Solution()
t = [[0, 1 ,2],
	 [3, 4, 5],
	 [6, 7, 8]]
sol.rotate(t)
print t
