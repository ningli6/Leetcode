# O(1) space, O(n) time

class Solution(object):
    def shortestDistance(self, words, word1, word2):
    	curIndex = -1
    	curWord = word1
    	minDist = len(words);
    	for x in range(len(words)):
    		if words[x] == word1 or words[x] == word2:
    			if curIndex < 0:
    				curIndex = x
    				curWord = words[x]
    			elif words[x] == curWord:
    				curIndex = x
    			else:
    				minDist = min(minDist, x - curIndex)
    				curIndex = x
    				curWord = words[x]
    	return minDist

sol = Solution()
print sol.shortestDistance(["practice", "makes", "perfect", "coding", "makes"], "practice", "coding")