'''
Merge overlapped interval is error prone
1. copy and create new intervals, because array is O(n) in delete, linked list is O(n) in locating element
2. can't just check overlap between consecutive intervals, need to first check if it overlaps with merged one
time: O(n * log(n)), space: O(n)
'''

from operator import attrgetter

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
		intervals.sort(key = attrgetter('start'))
		re = []
		count = 0
		re.append(Interval(intervals[count].start, intervals[count].end))
		for x in range(1, len(intervals)):
			if self.isOverlap(re[count], intervals[x]):
				re[count].end = max(re[count].end, intervals[x].end)
			else:
				re.append(Interval(intervals[x].start, intervals[x].end))
				count += 1
		return re


	# assume inta.start is no greater than intb.start
	def isOverlap(self, inta, intb):
		return inta.end >= intb.start

sol = Solution()
t = []
t.append(Interval(1, 10))
t.append(Interval(2, 14))
t.append(Interval(13, 15))
re = sol.merge(t)
for interv in re:
	interv.show()