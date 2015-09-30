class Solution(object):

	def shortestPalindrome(self, s):
		if not s or len(s) < 2:
			return s
		maxCom = self.maxSuPrefix(s + ' ' + s[::-1])  # space is necessary
		return s[maxCom[len(maxCom) - 1]:][::-1] + s
        

	def maxSuPrefix(self, s):
		maxCom = [0 for x in range(len(s))]
		for x in range(1, len(s)):
			index = maxCom[x - 1]
			while True:
				if s[x] == s[index]:
					maxCom[x] = index + 1
					break
				if index == 0:
					break
				index = maxCom[index - 1]  # after each fail, look at substring exclude the character
		return maxCom

sol = Solution()
print sol.shortestPalindrome("aabba")
# print sol.maxSuPrefix("aabbaabbaa")