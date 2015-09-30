class Solution:
	def groupStrings(self, strings):
		if not strings:
			return []
		strings.sort()
		re = []
		key_list = {}
		for str in strings:
			key = self.hash(str)
			if key in key_list:
				key_list[key].append(str)
			else:
				key_list[key] = [str]
				re.append(key_list[key])
		return re


	def hash(self, string):
		s = ''
		offset = ord(string[0]) - ord('a')
		for c in string:
			character = ord(c) - offset
			if character < 97:
				character += 26
			s += chr(character)
		return s

sol = Solution()
strings = ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
print sol.groupStrings(strings)