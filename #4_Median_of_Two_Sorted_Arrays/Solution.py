'''
The idea is to find the kth smallest element, in this case k is (m + n) / 2.
The key point is to discard half portion of k each time from either array.
Thus time complexity should be O(log(k)) = O(log(m + n))
'''
class Solution:
    # @param {integer[]} nums1
    # @param {integer[]} nums2
    # @return {float}
    def findMedianSortedArrays(self, nums1, nums2):
    	sum = 0
    	if nums1:
    		sum += len(nums1)
    	if nums2:
    		sum += len(nums2)
    	if not sum:
    		return sum
    	if sum % 2:
    		return self.findKth(nums1, nums2, sum / 2 + 1)
    	return (self.findKth(nums1, nums2, sum / 2) + self.findKth(nums1, nums2, sum / 2 + 1)) / 2.0

    def findKth(self, nums1, nums2, k):
    	if not nums1:
    		return nums2[k - 1]
    	if not nums2:
    		return nums1[k - 1]
    	if len(nums1) > len(nums2):
    		return self.findKth(nums2, nums1, k)
    	if k == 1:
    		return min(nums1[0], nums2[0])
    	pa = min(k / 2, len(nums1))
    	pb = k - pa
    	if nums1[pa - 1] < nums2[pb - 1]:
    		return self.findKth(nums1[pa:], nums2, k - pa)
    	if nums1[pa - 1] > nums2[pb - 1]:
    		return self.findKth(nums1, nums2[pb:], k - pb)
    	return nums1[pa - 1]

sol = Solution()
n1 = [1, 2, 3, 4, 5]
n2 = [6, 7, 8]
print sol.findMedianSortedArrays(n1, n2)
