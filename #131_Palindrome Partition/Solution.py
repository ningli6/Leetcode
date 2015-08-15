'''
Use dp to see if s[i, j] is palindrome in O(n ^ 2)
Then backtracing
'''

class Solution:

	def __init__(self):
		self.dp = None
		self.ans = []

	# @param {string} s
	# @return {string[][]}
	def partition(self, s):
		if not s:
			return []
		self.dp = [[False for j in range(len(s))] for i in range(len(s))]
		self.ans = []
		for x in range(len(s)):
			self.dp[x][x] = True
		for j in range(len(s)):
			for i in range(len(s)):
				if i >= j:
					break
				elif j - i == 1 and s[i] == s[j]:
					self.dp[i][j] = True
				elif s[i] == s[j] and self.dp[i + 1][j - 1]:
					self.dp[i][j] = True
		self.backtrace(s, 0, [])
		return self.ans

	def backtrace(self, s, index, tmp):
		if index == len(s):
			self.ans.append(list(tmp))
			return
		for x in range(index, len(s)):
			if self.dp[index][x]:
				tmp.append(s[index : x + 1])
				self.backtrace(s, x + 1, tmp)
				tmp.pop()

sol = Solution()
print sol.partition("aab")