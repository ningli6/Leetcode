class Solution:

    # comparator for string a, b
    def comparator(self, a, b):
        if a + b > b + a:
            return 1
        if a + b < b + a:
            return -1
        return 0

    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        return ''.join(sorted(map(str, nums), self.comparator, reverse=True)).lstrip('0') or '0'


sol = Solution()
print sol.largestNumber(['10'])