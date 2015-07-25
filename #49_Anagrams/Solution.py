class Solution:
	# @param {string[]} strs
	# @return {string[]}
	def anagrams(self, strs):
		if not strs:
			return []
		re = []
		map = {}
		for s in strs:
			ss = self.sortStr(s) # sorted string
			map[ss] = map.get(ss, 0) + 1
		for s in strs:
			if map[self.sortStr(s)] > 1:
				re.append(s)
		return re

	# radix sort, runs in linear time
	# @param {string} string
	# @return {string} hash value
	def sortStr(self, string):
		if not string:
			return string
		return ''.join(sorted(string))

sol = Solution()
print sol.sortStr("asp")
print sol.sortStr("jul")
# print sol.anagrams(["ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"])