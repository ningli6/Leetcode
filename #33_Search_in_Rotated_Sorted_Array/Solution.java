public class Solution {
    public int search(int[] nums, int target) {
    	if (nums.length == 0) return -1;
    	int lo = 0; int hi = nums.length;
    	return search(nums, target, lo, hi - 1);
    }

    private int search(int[] nums, int target, int lo, int hi) {
    	if (nums.length == 0) return -1;
    	if (lo > hi) return -1;
    	int mid = (lo + hi) / 2;
    	if (nums[mid] == target) return mid;
    	/* on the left */
    	if (nums[mid] < nums[lo]) {
    		if (target > nums[mid] && target <= nums[hi]) return search(nums, target, mid + 1, hi);
    		return search(nums, target, lo, mid - 1);
    	}
    	/* on the right */
    	if (nums[mid] > nums[hi]) {
    		if (target < nums[mid] && target >= nums[lo]) return search(nums, target, lo, mid - 1);
    		return search(nums, target, mid + 1, hi);
    	}
    	if (target < nums[mid]) return search(nums, target, lo, mid - 1);
    	return search(nums, target, mid + 1, hi);
    }

    public static void main(String[] args) {
    	int[] test = {4, 5, 6, 7, 0, 1, 2};
    	Solution sol = new Solution();
    	System.out.println(sol.search(test, 5));
    }
}