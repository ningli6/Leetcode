class Solution:

	def __init__(self):
		self.ans = None

	# @param s, a string
	# @param wordDict, a set<string>
	# @return a string[]
	def wordBreak(self, s, wordDict):
		if not s or not wordDict:
			return []
		if not self.breakable(s, wordDict):
			return []
		self.ans = []
		self.wb(s, wordDict, [])
		return self.ans

	def wb(self, s, wdic, tmp):
		if not s:
			re = ''
			for string in tmp:
				re += string
				re += ' '
			self.ans.append(re[:-1])
			return
		for x in range(len(s)):
			if s[:x + 1] in wdic:
				tmp.append(s[:x + 1])
				self.wb(s[x + 1:], wdic, tmp)
				tmp.pop()

	# @param s, a string
	# @param wordDict, a set<string>
	# @return a boolean
	def breakable(self, s, wordDict):
		dp = [False for x in range(len(s) + 1)]
		dp[0] = True
		for j in range(len(s)):
			for i in range(j + 1):
				if s[i : j + 1] in wordDict and dp[i]:
					dp[j + 1] = True
		return dp[len(s)]

sol = Solution()
dic = set(["cat", "cats", "and", "sand", "dog"])
print sol.wordBreak("catsanddog", dic)