class Solution(object):
    def isIsomorphic(self, s, t):
    	if not s and not t:
    		return True
    	if not s or not t:
    		return False
    	if len(s) != len(t):
    		return False
    	map = {}
    	rMap = set()
    	for x in range(len(s)):
    		if s[x] not in map:      # map a new char
    			map[s[x]] = t[x]
    			if t[x] not in rMap: # see if the mapped char has already been mapped
    				rMap.add(t[x])
    			else:
    				return False
    		else:
    			if t[x] != map[s[x]]: # see if the mapping char corresponds to different char
    				return False
    	return True

sol = Solution()
print sol.isIsomorphic("abc", "aa")