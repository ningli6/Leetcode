'''
time: O(n), space: O(1)
'''

class Interval:
	def __init__(self, s=0, e=0):
		self.start = s
		self.end = e

class Solution:
	# @param {Interval[]} intervals
	# @param {Interval} newInterval
	# @return {Interval[]}
	def insert(self, intervals, newInterval):
		if not newInterval:
			return intervals
		if not intervals:
			return [newInterval]
		cur = 0
		re = []
		while cur < len(intervals) and intervals[cur].end < newInterval.start:
			re.append(intervals[cur])
			cur += 1
		re.append(newInterval)
		while cur < len(intervals):
			if self.isOverlap(newInterval, intervals[cur]):
				newInterval.start = min(newInterval.start, intervals[cur].start)
				newInterval.end = max(newInterval.end, intervals[cur].end)
			else:
				re.append(intervals[cur])
			cur += 1
		return re

	def isOverlap(self, inta, intb):
		if inta.end < intb.start or intb.end < inta.start:
			return False
		return True