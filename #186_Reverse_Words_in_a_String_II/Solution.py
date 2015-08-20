class Solution(object):

    def reverseWords(self, s):
		if not s:
			return
		self.reverseList(s, 0, len(s) - 1)
		i, j = 0, 0
		while j < len(s):
			j += 1
			if j == len(s) or s[j] == ' ':  # checking index of j must comes first
				self.reverseList(s, i, j - 1)
				i = j + 1

    def reverseList(self, s, start, end):
    	if not s:
    		return
    	if start < 0 or end >= len(s):
    		return
    	i, j = start, end
    	while i <= j:
    		tmp = s[i]
    		s[i] = s[j]
    		s[j] = tmp
    		i += 1
    		j -= 1

sol = Solution()
t = list("tab bbc")
sol.reverseWords(t)
print t