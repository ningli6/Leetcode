# O(n) initialization and O(m + n) queries where m & n are number of time that string appears

class WordDistance(object):
    def __init__(self, words):
    	self.dic = {}
    	self.len = len(words)
    	for i in range(self.len):
    		if words[i] not in self.dic:
    			self.dic[words[i]] = []
    		self.dic[words[i]].append(i)

    def shortest(self, word1, word2):
    	list1 = self.dic[word1]
    	list2 = self.dic[word2]
    	re = self.len
    	i, j = 0, 0
    	while i < len(list1) and j < len(list2):
    		if list1[i] < list2[j]:
    			re = min(re, list2[j] - list1[i])
    			i += 1
    		else:
    			re = min(re, list1[i] - list2[j])
    			j += 1
    	return re

sol = WordDistance(["practice", "makes", "perfect", "coding", "makes"])
print sol.shortest("makes", "coding")