'''
BFS Solution
'''

from collections import deque

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
		queue = deque([beginWord])
		steps = 0
		cur = 1
		next = 0
		while queue:
			cur -= 1
			word = queue.popleft()
			wls = list(word)
			for x in range(len(word)):
				for c in range(97, 123):
					if c != ord(word[x]):
						wls[x] = chr(c)
						newWord = ''.join(wls)
						if newWord == endWord:
							return steps + 2
						if newWord in wordDict:
							queue.append(newWord)
							wordDict.remove(newWord)
							next += 1
						wls[x] = word[x]
			if cur == 0:
				steps += 1
				cur = next
				next = 0
		return 0

sol = Solution()
dic = set(["hot","dot","dog","lot","log"])
print sol.ladderLength("hit", "cog", dic)