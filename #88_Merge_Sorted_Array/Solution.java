public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) return;
        int cur1 = m - 1;
        int cur2 = n - 1;
        int cur = m + n - 1;
        while (cur1 >= 0 && cur2 >= 0) {
        	if (nums1[cur1] > nums2[cur2]) {
        		nums1[cur--] = nums1[cur1--];
        	}
        	else {
        		nums1[cur--] = nums2[cur2--];
        	}
        }
        while (cur2 >= 0) {
        	nums1[cur--] = nums2[cur2--];
        }
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = new int[10];
    	int[] b = {1};
    	sol.merge(t, 0, b, 1);
    	for (int i = 0; i < t.length; i++) {
    		System.out.print(t[i]);
    	}
    	System.out.println();
    }
}