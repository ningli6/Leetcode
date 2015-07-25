public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
	        int[] dp = new int[len + 1];
	        int j = i;
	        for (int c = 0; c < len; c++) {
	        	if (c == len - 1) {
	        		dp[c + 1] = dp[c];
	        	}
	        	else if (j == i) dp[c + 1] = nums[j];
	        	else {
	        		int possible = dp[c - 1] + nums[j];
	        		dp[c + 1] = (dp[c] > possible) ? dp[c] : possible;
	        	}
	        	j = (j + 1) % len;
	        }
	        if (dp[dp.length - 1] > max) max = dp[dp.length - 1];
        }
        return max;
    }

    public static void main(String[] args) {
    	int[] test = {1, 1, 1};
    	Solution sol = new Solution();
    	System.out.println(sol.rob(test));
    }
}