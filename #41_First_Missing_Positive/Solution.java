public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	while (nums[i] > 0 && nums[i] <= nums.length) {
        		if (nums[nums[i] - 1] == nums[i]) break; // can't just use nums[i] - 1 == i, deal with duplicates
        		swap(nums, i, nums[i] - 1);
        	}
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
    	if (nums == null || nums.length == 0) return;
    	if (i < 0 || j < 0 || i >= nums.length || j >= nums.length) return;
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {4, -2, 7, 1 ,3};
    	System.out.println(sol.firstMissingPositive(t));
    }
}