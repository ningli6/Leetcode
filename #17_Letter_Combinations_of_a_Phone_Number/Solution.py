'''
Backtracing DFS solution
'''

# class Solution:
# 	# @param {string} digits
# 	# @return {string[]}
# 	def letterCombinations(self, digits):
# 		if not digits:
# 			return []
# 		map = {'0': '',
# 				'1':    '', '2': 'abc', '3': 'def', 
# 				'4': 'ghi', '5': 'jkl', '6': 'mno', 
# 				'7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
# 		re = []
# 		self.dfs(re, map, digits, '')
# 		return re

# 	def dfs(self, result, map, digits, str):
# 		if not digits:
# 			result.append(str)
# 			return
# 		for c in map[digits[0]]:
# 			self.dfs(result, map, digits[1:], str + c)

'''
BFS soltuion
'''
from collections import deque

class Solution:
	# @param {string} digits
	# @return {string[]}
	def letterCombinations(self, digits):
		if not digits:
			return []
		map = {'0': '',
				'1':    '', '2': 'abc', '3': 'def', 
				'4': 'ghi', '5': 'jkl', '6': 'mno', 
				'7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
		queue = deque([''])
		for index, key in enumerate(digits):
			while len(queue[0]) == index:
				str = queue.popleft()
				for c in map[key]:
					queue.append(str + c)
		return queue


sol = Solution()
re = sol.letterCombinations("23")
for str in re:
	print str,
