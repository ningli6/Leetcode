class Solution:

	def __init__(self):
		self.alphabet = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
		self.divisor = [1000, 500, 100,   50, 10,   5,  1]
	# @param {integer} num
	# @return {string}
	def intToRoman(self, num):
		re = []
		i = 0
		while i < 7:
			quotient = num / self.divisor[i]
			if not quotient:
				i += 2
			elif quotient <= 3:
				for x in range(quotient):
					re.append(self.alphabet[i])
				num = num - quotient * self.divisor[i]
			elif quotient == 4:
				re.append(self.alphabet[i])
				re.append(self.alphabet[i - 1])
				num = num - quotient * self.divisor[i]
			elif quotient == 9:
				re.append(self.alphabet[i])
				re.append(self.alphabet[i - 2])
				num = num - quotient * self.divisor[i]
			else:
				re.append(self.alphabet[i - 1])
				num -= self.divisor[i - 1]
		return ''.join(re)


sol = Solution()
print sol.intToRoman(95)

