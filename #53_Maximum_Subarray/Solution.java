public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int localMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	localMax = (localMax < 0) ? nums[i] : nums[i] + localMax;
        	globalMax = (localMax > globalMax) ? localMax : globalMax;
        }
        return globalMax;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {-2,1, -3,4, -1,2,1, -5,4};
    	System.out.println(sol.maxSubArray(nums));
    }
}