class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.outStk = []
        self.inStk = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.inStk.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if self.empty():
            return
        if not self.outStk:
            while self.inStk:
                self.outStk.append(self.inStk.pop())
        self.outStk.pop()

    def peek(self):
        """
        :rtype: int
        """
        if not self.outStk:
            while self.inStk:
                self.outStk.append(self.inStk.pop())
        return self.outStk[len(self.outStk) - 1]

    def empty(self):
        """
        :rtype: bool
        """
        return not self.inStk and not self.outStk

queue = Queue()
print queue.empty()
queue.push(1)
queue.push(2)
queue.push(3)
print queue.empty()
# print queue.peek()
# queue.pop()
# print queue.peek()
# queue.pop()
# print queue.peek()
# queue.pop()
# print queue.empty()