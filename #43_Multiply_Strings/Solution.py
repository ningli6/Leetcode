'''
time O(m * n), space O(m + n) solution
'''

class Solution:
	# @param {string} num1
	# @param {string} num2
	# @return {string}
	def multiply(self, num1, num2):
		if not num1 or not num2:
			return '0'
		if (len(num1) == 1 and num1[0] == '0') or (len(num2) == 1 and num2[0] == '0'):
			return '0'
		m = len(num1)
		n = len(num2)
		ans = [0 for x in range(m + n)]
		for i in range(m):
			for j in range(n):
				index = m + n - (i + j) - 1
				val = ans[index] + (ord(num1[m - i - 1]) - ord('0')) * (ord(num2[n - j - 1]) - ord('0'))
				ans[index] = val % 10
				ans[index - 1] += val / 10
		return ''.join(str(x) for x in ans).lstrip('0')


sol = Solution()
print sol.multiply("35", "24")