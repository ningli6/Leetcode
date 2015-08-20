class TwoSum:

    # initialize your data structure here
    def __init__(self):
        self.element = {}

    # @return nothing
    def add(self, number):
        self.element[number] = self.element.get(number, 0) + 1

    # @param value, an integer
    # @return a Boolean
    def find(self, value):
        for num in self.element:
        	pair = value - num
        	if pair == num:
        		if self.element[pair] > 1:
	        		return True
        	elif pair in self.element:
        		return True
        return False

sol = TwoSum()
sol.add(0)
sol.add(0)
print sol.find(0)