class Solution(object):
    def calculate(self, s):
        if not s:
        	return 0
        stack = []
        re = 0
        num = 0
        sign = 1 # 1 for +, -1 for -, 2 for *, 3 for /
        for c in s:
        	if c.isdigit():
        		num = num * 10 + ord(c) - ord('0')
        	elif c == '+' or c == '-':
        		if stack:
        			if sign == 2:
        				re *= num
        			if sign == 3:
        				re /= num
        			re *= stack.pop()
        			re += stack.pop()
        		else:			
		    		re += num * sign
	    		num = 0
	    		if c == '+':
	    			sign = 1
	    		else:
	    			sign = -1
        	elif c == '*' or c =='/':
        		if not stack:
	        		stack.append(re)
	        		stack.append(sign)
	        		re = num
	        	else:
	        		if sign == 2:
	        			re *= num
	        		if sign == 3:
	        			re /= num
        		num = 0
        		if c == '*':
        			sign = 2
        		else:
        			sign = 3
        if num != 0:
        	if sign == 2:
        		re *= num
        	elif sign == 3:
        		re /= num
    		if stack:
    			re *= stack.pop()
    			re += stack.pop()
    		if sign == -1 or sign == 1:
    			re += sign * num
        return re

sol = Solution()
print sol.calculate("1 + 2 * 3")