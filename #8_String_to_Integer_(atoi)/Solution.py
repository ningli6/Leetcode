'''
need to trim space on both sides
may start with +/- (optional)
trim leading 0s
ignore invalid sequece, the converted part remains
watch for overflow
'''


class Solution:
    # @param {string} str
    # @return {integer}
    
    def __init__(self):
     	self.maxVal = 2**31 - 1
    
    def myAtoi(self, str):
        if not str:
        	return 0
        # trim space on both sides
        str = str.strip()
        sign = True
        if str[0] == '-':
        	sign = False
        # trim sign if exist
        str = self.truncateSign(str)
        # trim leading 0s
        str = str.lstrip('0')
        if not str:
        	return 0
        # convert to int
        re = 0
        for i in range(len(str)):
        	if sign and re > self.maxVal:
        		return self.maxVal
        	if not sign and re > self.maxVal + 1:
        		return -1 * self.maxVal - 1
        	if not self.isDigit(str[i]):
        		break
        	re = 10 * re + ord(str[i]) - 48
        # check for overflow
    	if sign and re > self.maxVal:
    		return self.maxVal
    	if not sign and re > self.maxVal + 1:
    		return -1 * self.maxVal - 1
        if sign:
        	return re
        return -1 * re

    def truncateSign(self, str):
    	if not str:
    		return str
    	if str[0] == '+' or str[0] == '-':
    		return str[1:]
    	return str

    def isDigit(self, char):
    	return char >= '0' and char <= '9'


sol = Solution()
print sol.myAtoi("-2147483649")