class Solution:
	# @param {integer} numerator
	# @param {integer} denominator
	# @return {string}
	def fractionToDecimal(self, numerator, denominator):
		if denominator == 0:
			raise ZeroDivisionError()
		if numerator == 0:
			return '0'
		if numerator > 0 and denominator < 0 or numerator < 0 and denominator > 0:
			return '-' + self.fractionToDecimal(abs(numerator), abs(denominator))
		numerator = abs(numerator)
		denominator = abs(denominator)
		integral = str(numerator / denominator)
		r = numerator % denominator
		if r == 0:
			return integral
		decimal = ''
		nums = {}
		count = 0
		while r != 0 and r not in nums:
			nums[r] = count
			count += 1
			decimal += str(r * 10 / denominator)
			r = r * 10 % denominator
		if r != 0:
			decimal = decimal[:nums[r]] + '(' + decimal[nums[r]:] + ')'
		return integral + '.' + decimal

sol = Solution()
print sol.fractionToDecimal(0, 3)