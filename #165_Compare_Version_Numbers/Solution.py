class Solution:
	# @param {string} version1
	# @param {string} version2
	# @return {integer}
	def compareVersion(self, version1, version2):
		if not version1 and not version2:
			return 0
		if not version1:
			return -1
		if not version2:
			return 1
		v1 = version1.split('.')
		v2 = version2.split('.')
		x = 0
		while x < min(len(v1), len(v2)):
			if int(v1[x]) > int(v2[x]):
				return 1
			if int(v1[x]) < int(v2[x]):
				return -1
			x += 1
		while x < len(v1):
			if int(v1[x]) > 0:
				return 1
			x += 1
		while x < len(v2):
			if int(v2[x]) > 0:
				return -1
			x += 1
		return 0

sol = Solution()
print sol.compareVersion("0.0.03.3", "0.1.0")