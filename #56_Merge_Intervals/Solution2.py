'''
Merge sort
need some sort function to partition array, then need some merge function to merge two list
time: O(n * log(n)), space: O(log(n))
'''

class Interval:
	def __init__(self, s=0, e=0):
		self.start = s
		self.end = e

	def show(self):
		print self.start, self.end

class Solution:
	# @param {Interval[]} intervals
	# @return {Interval[]}
	def merge(self, intervals):
		if not intervals:
			return []
		if len(intervals) == 1:
			return intervals
		return self.mergeIntervals(self.merge(intervals[:len(intervals) / 2]), self.merge(intervals[len(intervals) / 2:]))

	# Given two random intervals, return sorted merged intervals
	# @param {Interval[]} leftInt
	# @param {Interval[]} rightInt
	# @return {Interval[]}
	def mergeIntervals(self, leftInt, rightInt):
		if not leftInt:
			return rightInt
		if not rightInt:
			return leftInt
		re = []
		i, j = 0, 0
		count = 0
		if leftInt[i].start < rightInt[j].start:
			re.append(leftInt[i])
			i += 1
		else:
			re.append(rightInt[j])
			j += 1
		while i < len(leftInt) or j < len(rightInt):
			if i < len(leftInt) and j < len(rightInt):
				if leftInt[i].start < rightInt[j].start:
					minInt = leftInt[i]
					i += 1
				else:
					minInt = rightInt[j]
					j += 1
			elif i < len(leftInt):
				minInt = leftInt[i]
				i += 1
			else:
				minInt = rightInt[j]
				j += 1
			if self.isOverlap(re[count], minInt):
				re[count].end = max(re[count].end, minInt.end)
			else:
				re.append(minInt)
				count += 1
		return re

	# assume inta.start is no greater than intb.start
	def isOverlap(self, inta, intb):
		return inta.end >= intb.start
		
sol = Solution()
t = []
t.append(Interval(1, 4))
t.append(Interval(3, 7))
t.append(Interval(12, 14))
re = sol.merge(t)
for interv in re:
	interv.show()
print
for interv in t:
	interv.show()