public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) result ^= nums[i];
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 1, 2, 2, 3, 3, 5};
    	System.out.println(sol.singleNumber(nums));
    }
}