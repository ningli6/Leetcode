'''
 clockwise rotate
 first reverse up to down, then swap the symmetry 
 1 2 3     7 8 9     7 4 1
 4 5 6  => 4 5 6  => 8 5 2
 7 8 9     1 2 3     9 6 3
'''

class Solution:
	# @param {integer[][]} matrix
	# @return {void} Do not return anything, modify matrix in-place instead.
	def rotate(self, matrix):
		if not matrix or len(matrix) < 2:
			return
		matrix.reverse()
		self.symmetry(matrix)

	def symmetry(self, matrix):
		n = len(matrix)
		for i in range(n):
			for j in range(i, n):
				self.swap(matrix, i, j, j, i)


	def swap(self, matrix, i, j, x, y):
		tmp = matrix[x][y]
		matrix[x][y] = matrix[i][j]
		matrix[i][j] = tmp

sol = Solution()
t = [[0, 1 ,2],
	 [3, 4, 5],
	 [6, 7, 8]]
sol.rotate(t)
print t