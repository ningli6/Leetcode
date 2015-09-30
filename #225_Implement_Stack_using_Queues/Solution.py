'''
O(1) pop
O(n) push
'''

from collections import deque

class Stack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.queue = deque()
        self.aux = deque()

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.aux.append(x)
        while self.queue:
            self.aux.append(self.queue.popleft())
        tmp = self.aux
        self.aux = self.queue
        self.queue = tmp

    def pop(self):
        """
        :rtype: nothing
        """
        if not self.empty():
            self.queue.popleft()

    def top(self):
        """
        :rtype: int
        """
        return self.queue[0]

    def empty(self):
        """
        :rtype: bool
        """
        return not bool(self.queue)

stk = Stack()
print stk.empty()
stk.push(5)
stk.push(10)
stk.push(30)
print stk.empty()
stk.pop()
print stk.top()
stk.pop()
stk.pop()
print stk.empty()