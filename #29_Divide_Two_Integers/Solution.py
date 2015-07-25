class Solution:
	# @param {integer} dividend
	# @param {integer} divisor
	# @return {integer}
	# assume that dividend and divisor are both positive
	def divide(self, dividend, divisor):
		if dividend == 0:
			return 0
		elif dividend < 0 and divisor < 0:
			return min(self.divide(~dividend + 1, ~divisor + 1), 2147483647)
		elif dividend < 0 and divisor > 0:
			return ~self.divide(~dividend + 1, divisor) + 1
		elif dividend > 0 and divisor < 0:
			return ~self.divide(dividend, ~divisor + 1) + 1
		elif dividend < divisor:
			return 0
		else:
			sum = divisor
			re = 1
			while sum + sum <= dividend:
				sum += sum
				re += re
			return re + self.divide(dividend - sum, divisor)


sol = Solution()
print sol.divide(1, 2)