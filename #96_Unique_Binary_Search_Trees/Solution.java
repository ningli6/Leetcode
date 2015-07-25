/* time: O(n^2) */

public class Solution {
    public int numTrees(int n) {
    	if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= i; j++) {
        		dp[i] += dp[j - 1] * dp[i - j];
        	}
        }
        return dp[n];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.numTrees(3));
    }
}