public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return (word2 == null) ? 0 : word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        // dp[i][j] minimum distance between w1[0, i) and w2[0, j)
        int[] dp = new int[word2.length() + 1];
        for (int j = 1; j <= word2.length(); j++) {
        	dp[j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
			int prev = dp[0];
			dp[0] = dp[0] + 1;
        	for (int j = 1; j <= word2.length(); j++) {
    			int tmp = dp[j];
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[j] = prev;
        		else dp[j] = Math.min(Math.min(prev + 1, dp[j] + 1), dp[j - 1] + 1);
        		prev = tmp;
        	}
        }
        return dp[word2.length()];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.minDistance("sea", "ate"));
    }
}