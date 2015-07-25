public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) return 0;
        if (nums1 == null || nums1.length == 0) 
        	return (nums2.length % 2 == 0) ? (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0 
									        : nums2[nums2.length / 2];
        if (nums2 == null || nums2.length == 0) 
        	return (nums1.length % 2 == 0) ? (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0 
									        : nums1[nums1.length / 2];
        int len = nums1.length + nums2.length;
        return len % 2 == 0 ? (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0 
						        : findKth(nums1, 0, nums2, 0, (len + 1) / 2);  
    }

    private double findKth(int[] nums1, int m, int[] nums2, int n, int k) {
    	if (m >= nums1.length) return nums2[k - 1];
    	if (n >= nums2.length) return nums1[k - 1];
    	if (k == 1) return Math.min(nums1[m], nums2[n]);
    	/* assume nums1.length <= nums2.length */
    	if (nums1.length > nums2.length) return findKth(nums2, n, nums1, m, k);
    	int pa = Math.min(k / 2, nums1.length - m);
    	int pb = k - pa;
    	if (nums1[pa - 1 + m] < nums2[pb - 1 + n]) return findKth(nums1, m + pa, nums2, n, k - pa);
    	if (nums1[pa - 1 + m] > nums2[pb - 1 + n]) return findKth(nums1, m, nums2, n + pb, k - pb);
    	return nums1[pa - 1 + m];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] a = {1, 1};
    	int[] b = {1, 2};
    	System.out.println(sol.findMedianSortedArrays(a, b));
    }
}