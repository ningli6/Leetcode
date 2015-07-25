class Solution:
    # @param {integer} n
    # @return {string}
    def countAndSay(self, n):
        if n < 1:
        	return ''
        s = '1'
        if n == 1:
        	return s
        for x in range(n - 1):
        	t = ''
        	i = 0
        	while i < len(s):
        		j = 1
        		while i + j < len(s) and s[i + j - 1] == s[i + j]:
        			j += 1
        		t += str(j)
        		t += s[i]
        		i += j
        	s = t
        return s

sol = Solution()
print sol.countAndSay(2)
