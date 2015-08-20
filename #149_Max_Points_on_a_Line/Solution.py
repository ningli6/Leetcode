'''
For each point, look at lines at every other points formed with this point, keep track of that line
O(n ^ 2) Solution
'''

# Definition for a point.
class Point:
	def __init__(self, a=0, b=0):
		self.x = a
		self.y = b

class Solution:
	# @param {Point[]} points
	# @return {integer}
	def maxPoints(self, points):
		if not points:
			return 0
		if len(points) < 3:
			return len(points)
		re = 0
		maps = [{} for x in range(len(points))]
		for i in range(len(points)):
			# print '(', points[i].x ,', ', points[i].y ,')'
			dup = 0
			for j in range(len(points)):
				p1 = points[i]
				p2 = points[j]
				if self.samePoint(p1, p2):
					dup += 1
					continue
				tx = p1.x - p2.x        # dx & dy can be negative
				ty = p1.y - p2.y
				gcd = self.gcd(tx, ty)  # instead of computing ax + by + c = 0 which is inaccurate for double, use dx/gcd, dy/gcd as measure
				t = (tx / gcd, ty / gcd)
				maps[i][t] = maps[i].get(t, 0) + 1
			# print 'dup', dup
			sameLine = 0
			for line in maps[i]:
				sameLine = max(sameLine, maps[i].get(line))
			# print 'sameLine', sameLine
			re = max(re, sameLine + dup)
		return re

	# is point a, b the same point or same location
	def samePoint(self, a, b):
		return (a is b) or (a.x == b.x and a.y == b.y)

	# find the greatest common divisor
	def gcd(self, a, b):
		if b == 0:
			return a
		return self.gcd(b, a % b)

sol = Solution()
p1 = Point(0, 0)
p2 = Point(1, 1)
p3 = Point(1, -1)
print sol.maxPoints([p1, p2, p3])