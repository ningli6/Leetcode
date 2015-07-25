public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[i + 1] = nums[i];
            else {
                int possible = nums[i] + dp[i - 1];
                dp[i + 1] = (possible > dp[i]) ? possible : dp[i];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] house = {2, 3, 2};
        System.out.println(sol.rob(house));
    }
}