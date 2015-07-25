'''
Reverse the integer, compare it with its original value
'''

class Solution:
    # @param {integer} x
    # @return {boolean}

    def isPalindrome(self, x):
    	if x < 0:
    		return False
        if x < 10:
        	return True
        rev = 0
        t = x
        while t:
        	rev = rev * 10 + t % 10
        	t /= 10
        return rev == x
