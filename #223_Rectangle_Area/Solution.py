class Rectangle(object):
    def __init__(self, t, b, l, r):
        self.top = t
        self.bot = b
        self.left = l
        self.right = r

    def isValid(self):
        return self.top > self.bot and self.right > self.left

    def area(self):
        if not self.isValid():
            return 0
        return (self.top - self.bot) * (self.right - self.left)

    def overlapArea(self, rec):
        if not rec or not rec.isValid():
            return 0
        top = min(self.top, rec.top)
        bot = max(self.bot, rec.bot)
        left = max(self.left, rec.left)
        right = min(self.right, rec.right)
        return Rectangle(top, bot, left, right).area()
        

class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        rec1 = Rectangle(D, B, A, C)
        rec2 = Rectangle(H, F, E, G)
        return rec1.area() + rec2.area() - rec1.overlapArea(rec2)

sol = Solution()
print sol.computeArea(0, 0, 0, 0, -1, -1, 1, 1)