'''
Implement rabin karp algorithm for substring search

Monte Carlo version:
always runs in linear time
not always correct
no extra space
do not need back up

Las Vegas version:
always correct
extremely likely to run in linear time
worst case O(m * n)
need back up
'''

class RabinKarp:

	def __init__(self):
		self.R = 256
		self.Q = 997 # large random prime

	def strStr(self, txt, pattern):
		if not txt and not pattern:
			return 0
		if not txt and pattern:
			return -1
		if txt and not pattern:
			return 0
		if len(txt) < len(pattern):
			return -1
		rm = self.R**(len(pattern) - 1)
		ph = self.hash(pattern, len(pattern))
		th = self.hash(txt, len(pattern))
		if ph == th:
			return 0
		for x in range(len(pattern), len(txt)):
			th = th + self.Q - (ord(txt[x - len(pattern)]) * rm) % self.Q
			th = (th * self.R + ord(txt[x])) % self.Q
			if th == ph:
				if self.check(txt[x - len(pattern) + 1: x + 1], pattern):
					return x - len(pattern) + 1
				continue
		return -1


	# compute hash value of string for first m charaters
	# must make sure lenght of string is no less than m
	# @param {string} s
	# @param {int} m
	# return {int} hash value
	def hash(self, s, m):
		re = 0
		for i in range(m):
			re = (re * self.R + ord(s[i])) % self.Q
		return re

	# Las Vegas version: check for mismatch
	# @param {string} s
	# @param {string} p
	# return {boolean} s == p ?
	def check(self, s, p):
		return s == p


rabinKarp = RabinKarp()
t = "abcdefg"
p = "defg"
print rabinKarp.strStr(t, p)