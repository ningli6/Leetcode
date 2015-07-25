public class Solution {
    public int minCut(String s) {
        if (s == null) return 0;
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len + 1][len + 1];
        int[] dp = new int[len];
        /* initialize */
        for (int i = 0; i < len; i++) {
        	dp[i] = i;
        }
        for (int i = 0; i < len + 1; i++) {
        	isPalindrome[i][i] = true;
        }
        for (int j = 1; j < len + 1; j++) {
        	for (int i = 0; i < j; i++) {
    			isPalindrome[i][j] = (s.charAt(i) == s.charAt(j - 1) && ((j - i == 1) || isPalindrome[i + 1][j - 1]));
    			if (isPalindrome[i][j]) {
	    			if (i == 0) dp[j - 1] = 0;
    				else dp[j - 1] = (1 + dp[i - 1] < dp[j - 1]) ? 1 + dp[i - 1] : dp[j - 1];
    			}
        	}
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.minCut("cdd"));
    }
}