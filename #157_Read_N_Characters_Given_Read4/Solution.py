# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):

class Solution:
	# @param buf, Destination buffer (a list of characters)
	# @param n,   Maximum number of characters to read (an integer)
	# @return     The number of characters read (an integer)
	def read(self, buf, n):
		count = 0
		tmpBuffer = []
		while count < n:
			inc = read4(tmpBuffer)
			if inc == 0: # eof
				break
			for c in tmpBuffer:
				buf.append(c)
				count += 1
				if count == n:
					break
		return count