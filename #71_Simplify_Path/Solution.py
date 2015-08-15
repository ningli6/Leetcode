'''
Corner case:
/../
/home//foo/
'''

class Solution:
    # @param {string} path
    # @return {string}
    def simplifyPath(self, path):
        if not path:
        	return '/'
        pathList = [d for d in path.split('/') if d and d != '.']
        dirs = []
        for d in pathList:
        	if d == '..':        		
        		if dirs:
        			dirs.pop()
        			dirs.pop()
        	else:
        		dirs.append('/')
        		dirs.append(d)
        if not dirs:
        	dirs.append('/')
        return ''.join(dirs)

sol = Solution()
print sol.simplifyPath("/home/")