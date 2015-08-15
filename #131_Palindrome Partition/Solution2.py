'''
Use dp to see if s[i, j] is palindrome in O(n ^ 2)
Then backtracing
'''

class Solution:

	def __init__(self):
		self.dp = None

	# @param {string} s
	# @return {string[][]}
	def partition(self, s):
		if not s:
			return []
		self.dp = [[False for j in range(len(s))] for i in range(len(s))]
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
		return self.backtrace(s, 0)

	def backtrace(self, s, index):
		ans = []
		for x in range(index, len(s)):
			if self.dp[index][x]:
				re = self.backtrace(s, x + 1)
				if re:
					for str in re:
						str.append(s[index : x + 1])
						ans.append(str)
				elif x + 1 == len(s):
					return [[s[index : x + 1]]]
		return ans

sol = Solution()
print sol.partition("aab")