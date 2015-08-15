class Solution:
	# @param {integer[]} digits
	# @return {integer[]}
	def plusOne(self, digits):
		if not digits:
			return [1]
		carry = False
		for x in range(len(digits) - 1, -1, -1):
			if digits[x] == 9:
				digits[x] = 0
				carry = True
			else:
				digits[x] += 1
				carry = False
			if not carry:
				break
		if carry:
			digits.insert(0, 1)
		return digits