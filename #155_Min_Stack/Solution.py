class MinStack:
	# initialize your data structure here.
	def __init__(self):
		self.eleStack = []
		self.minStack = []

	# @param x, an integer
	# @return nothing
	def push(self, x):
		self.eleStack.append(x)
		if not self.minStack or x <= self.getMin():
			self.minStack.append(x)

	# @return nothing
	def pop(self):
		if not self.eleStack:
			return
		if self.eleStack.pop() == self.getMin():
			self.minStack.pop()

	# @return an integer
	def top(self):
		return self.eleStack[len(self.eleStack) - 1]

	# @return an integer
	def getMin(self):
		return self.minStack[len(self.minStack) - 1]

mstk = MinStack()
mstk.push(1)
mstk.push(2)
mstk.push(3)
mstk.pop()
mstk.push(-1)
mstk.pop()
print mstk.getMin()