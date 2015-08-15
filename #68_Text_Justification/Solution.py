import math

class Solution:
    # @param {string[]} words
    # @param {integer} maxWidth
    # @return {string[]}
    def fullJustify(self, words, maxWidth):
        if not words:
        	return []
        ans = []
        i, j = 0, 0  # use i, j as a sliding windows for candidate words
        while i < len(words):
        	L = maxWidth
        	sum = 0
        	while j < len(words) and L >= len(words[j]):
        		L -= len(words[j]) + 1
        		sum += len(words[j])
        		j += 1
    		re = []
    		space = maxWidth - sum
        	if j < len(words): # not last line
        		while i < j:
        			re.append(words[i])
        			if j - i == 1: # compute space
        				count = space
        			else:
        				count = int(math.ceil(space / float(j - i - 1)))
        			for x in range(count):
        				re.append(' ')
        			space -= count
        			i += 1
        	else: # last line
        		while i < j:
        			re.append(words[i])
        			if space > 0:
        				re.append(' ')
        				space -= 1
        			i += 1
        		for x in range(space): # add additional space to the right
        			re.append(' ')
    		ans.append(''.join(re))
    	return ans

sol = Solution()
print sol.fullJustify(["This", "is", "an", "example", "of", "text", "justification."], 16)