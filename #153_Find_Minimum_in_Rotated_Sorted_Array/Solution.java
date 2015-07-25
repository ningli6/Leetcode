public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1;
        while (true) {
        	int mid = (lo + hi) / 2;
	        if (nums[lo] <= nums[mid] && nums[mid] <= nums[hi]) return nums[lo];
        	if (nums[lo] <= nums[mid]) lo = mid + 1;
        	else if (nums[mid] < nums[hi]) hi = mid;
        }
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(sol.findMin(t));
    }
}