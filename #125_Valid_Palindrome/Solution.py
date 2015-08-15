class Solution:
    # @param {string} s
    # @return {boolean}
    def isPalindrome(self, s):
        if not s:
        	return True
        s = s.lower()
        i, j = 0, len(s) - 1
        while i <= j:
        	if not s[i].isdigit():
        		i += 1
        		continue
        	if not s[j].isdigit():
        		j -= 1
        		continue
        	if s[i] == s[j]:
        		i += 1
        		j -= 1
        	else:
        		return False
        return True

sol = Solution()
print sol.isPalindrome("race a car")