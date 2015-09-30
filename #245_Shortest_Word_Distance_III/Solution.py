class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
    	cur = -1
    	minDist = len(words);
    	for x in range(len(words)):
    		if words[x] == word1 or words[x] == word2:
    			if cur < 0 or words[x] == words[cur]:
    				if cur >= 0 and word1 == word2:
    					minDist = min(minDist, x - cur)
    				cur = x
    			else:
    				minDist = min(minDist, x - cur)
    				cur = x
    	return minDist

sol = Solution()
print sol.shortestWordDistance(["practice", "makes", "perfect", "coding", "makes"], "makes", "makes")