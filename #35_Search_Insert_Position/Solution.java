public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private static int searchInsert(int[] nums, int target, int lo, int hi) {
    	if (lo > hi) return lo;
    	int mid = (lo + hi) / 2;
    	if (nums[mid] == target) return mid;
    	if (nums[mid] > target) return searchInsert(nums, target, lo, mid - 1);
    	return searchInsert(nums, target, mid + 1, hi);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1,3,5,6};
    	System.out.println(sol.searchInsert(t, 0));
    	System.out.println(sol.searchInsert(t, 1));
    	System.out.println(sol.searchInsert(t, 2));
    	System.out.println(sol.searchInsert(t, 3));
    	System.out.println(sol.searchInsert(t, 4));
    	System.out.println(sol.searchInsert(t, 5));
    	System.out.println(sol.searchInsert(t, 6));
    	System.out.println(sol.searchInsert(t, 7));
    }
}