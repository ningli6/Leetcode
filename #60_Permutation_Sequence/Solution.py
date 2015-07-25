'''
time: O(n * n)
space: O(n)
'''

class Solution:

	def __init__(self):
		self.ans = None

	# @param {integer} n
	# @param {integer} k
	# @return {string}
	def getPermutation(self, n, k):
		if n == 0 or k == 0:
			return ''
		if n == 1:
			return '1'
		self.ans = []
		count = 1
		nums = [str(count) for count in range(1, n + 1)]
		self.KthPermutation(nums, k - 1, self.factorial(n - 1))
		return ''.join(self.ans)

	# @param {integer} nums   set of numbers
	# @param {integer} k      k index element in the array
	# @param {integer} factN  (n - 1)!
	# @return {integer[]} chosen character
	def KthPermutation(self, nums, k, factN):
		if len(nums) == 1:
			return self.ans.append(nums[0])
		nums.sort()
		self.swap(nums, 0, k / factN)
		self.ans.append(nums[0])
		self.KthPermutation(nums[1:], k - factN * (k / factN), factN / len(nums[1:]))

	def factorial(self, n):
		ans = 1
		while n > 0:
			ans *= n
			n -= 1
		return ans

	def swap(self, nums, i, j):
		if i == j:
			return
		tmp = nums[j]
		nums[j] = nums[i]
		nums[i] = tmp

sol = Solution()
print sol.getPermutation(3, 3)