class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    def convert(self, s, numRows):
        if not s or numRows <= 1 or len(s) <= numRows:
        	return s
        re = []
        for i in range(numRows):
        	sd = 2 * (numRows - i - 1)
        	su = 2 * i
        	cur = i
    		re.append(s[cur])
        	while True:
        		cur += sd
        		if cur >= len(s):
        			break
        		if sd:
	        		re.append(s[cur])
        		cur += su
        		if cur >= len(s):
        			break
        		if su:
	        		re.append(s[cur])
        return ''.join(re)


sol = Solution()
print sol.convert("PAYPALISHIRING", 3)