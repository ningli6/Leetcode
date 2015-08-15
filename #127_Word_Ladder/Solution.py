'''
DFS solution ETL
'''

import sys

class Solution:
	# @param {string} beginWord
	# @param {string} endWord
	# @param {set<string>} wordDict
	# @return {integer}
	def ladderLength(self, beginWord, endWord, wordDict):
		if beginWord == endWord:
			return 1
		if not wordDict:
			return 0
		re = sys.maxint
		wordList = list(beginWord)
		for i in range(len(wordList)):
			for x in range(ord('a'), ord('z') + 1):
				if chr(x) != beginWord[i]:
					wordList[i] = chr(x)
					newWord = ''.join(wordList)
					if newWord == endWord:
						return 2
					if newWord in wordDict:
						wordDict.remove(newWord)
						ans = self.ladderLength(newWord, endWord, wordDict)
						if ans > 0:
							re = min(ans, re)
						wordDict.add(newWord)
					wordList[i] = beginWord[i]
		if re == sys.maxint:
			return 0
		return re + 1

sol = Solution()
dic = set(["hot","dot","dog","lot","log"])
print sol.ladderLength("hit", "cog", dic)