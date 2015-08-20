class Solution:
    # @param {string} s
    # @param {string} t
    # @return {boolean}
    def isOneEditDistance(self, s, t):
    	if not s and not t:
    		return False
        if not s:
        	if len(t) > 1:
        		return False
        	return True
        if not t:
        	if len(s) > 1:
        		return False
        	return True
        if abs(len(s) - len(t)) > 1:
        	return False
        if len(s) > len(t):
        	return self.isOneEditDistance(t, s)
        if len(s) == len(t):
        	i, j = 0, 0
        	diff = 0
        	while i < len(s) and j < len(t):
        		if s[i] != t[j]:
        			diff += 1
        		i += 1
        		j += 1
        	return diff == 1
        i, j = 0, 0
        while i < len(s) and j < len(t):
        	if s[i] == t[j]:
        		i += 1
        	j += 1
        if j == i:
        	return True
        return j - i == 1

sol = Solution()
print sol.isOneEditDistance("a", "ac")