class Solution:
    # @param {string} s1
    # @param {string} s2
    # @param {string} s3
    # @return {boolean}
    def isInterleave(self, s1, s2, s3):
    	if not s1:
    		return s2 == s3
    	if not s2:
    		return s1 == s3
        if len(s1) + len(s2) != len(s3):
        	return False
        # s1, s2, s3 are not empty strings by now
        if s1[0] == s3[0]:
            if self.isInterleave(s1[1:], s2, s3[1:]):
                return True
        if s2[0] == s3[0]:
            if self.isInterleave(s1, s2[1:], s3[1:]):
                return True
        return False

sol = Solution()
print sol.isInterleave('aabcc', 'dbbca', 'aadbbbaccc')