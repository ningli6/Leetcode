class Solution:
	# @param {string} a
	# @param {string} b
	# @return {string}
	def addBinary(self, a, b):
		lena, lenb = len(a), len(b)
		re = ['0' for x in range(max(lena, lenb) + 1)]
		cur = len(re) - 1
		i, j = lena - 1, lenb - 1
		while i >= 0 or j >= 0:
			sum = ord(re[cur]) - 48
			if i >= 0:
				sum += ord(a[i]) - 48
				i -= 1
			if j >= 0:
				sum += ord(b[j]) - 48
				j -= 1
			re[cur] = chr(sum % 2 + 48)
			re[cur - 1] = chr(sum / 2 + 48)
			cur -= 1
		ans = ''.join(re).lstrip('0')
		if not ans:
			return '0'
		return ans

sol = Solution()
print sol.addBinary('11', '11')
