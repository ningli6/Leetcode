class Solution(object):
    def findStrobogrammatic(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n <= 0:
        	return []
        if n == 1:
        	return ['0', '1', '8']
        if n == 2:
        	return ["11","69","88","96"]
        re = self.generateNum(n - 2)
        ans = []
        for s in re:
        	ans.append('1' + s + '1')
        	ans.append('6' + s + '9')
        	ans.append('8' + s + '8')
        	ans.append('9' + s + '6')
        return ans

    def generateNum(self, n):
        if n == 1:
        	return ['0', '1', '8']
        if n == 2:
        	return ["00", "11","69","88","96"]
        mid = self.generateNum(n - 2)
        ans = []
        for s in mid:
        	ans.append('0' + s + '0')
        	ans.append('1' + s + '1')
        	ans.append('6' + s + '9')
        	ans.append('8' + s + '8')
        	ans.append('9' + s + '6')
        return ans

sol = Solution()
print sol.findStrobogrammatic(5)