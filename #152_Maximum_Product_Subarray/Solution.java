public class Solution {
    public int maxProduct(int[] nums) {
		if (nums.length == 0) return 0;
		int localMin = nums[0];
		int localMax = nums[0];
		int globalMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prevMin = localMin;
			localMin = Math.min(nums[i], Math.min(localMin * nums[i], localMax * nums[i]));
			localMax = Math.max(nums[i], Math.max(prevMin * nums[i], localMax * nums[i]));
			globalMax = (globalMax > localMax) ? globalMax : localMax;
		}
		return globalMax;
    }

    public static void main(String[] args) {
    	int[] nums = {1, -2, 3, -4, 5, -6};
    	Solution sol = new Solution();
    	System.out.println(sol.maxProduct(nums));
    }
}