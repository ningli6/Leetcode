public class Solution {
    public int findPeakElement(int[] nums) {
    	if (nums.length == 1) return 0;
        int lo = 0; int hi = nums.length - 1;
        return findPeakElement(nums, lo, hi);
    }

    private int findPeakElement(int[] nums, int lo, int hi) {
    	int mid = (lo + hi) / 2;
    	int prev, next;
    	if (mid - 1 < 0) prev = Integer.MIN_VALUE;
    	else prev = nums[mid - 1];
    	if (mid + 1 >= nums.length) next = Integer.MIN_VALUE;
    	else next = nums[mid + 1];
    	if (nums[mid] > prev && nums[mid] > next) return mid;
    	if (nums[mid] >= prev && nums[mid] < next) return findPeakElement(nums, mid + 1, hi);
    	if (nums[mid] < prev && nums[mid] > next) return findPeakElement(nums, lo, mid - 1);
    	return findPeakElement(nums, mid + 1, hi);
    }

    public static void main(String[] args) {
    	int[] s = {2, 1, 2};
    	Solution sol = new Solution();
    	System.out.println(sol.findPeakElement(s));
    }
}