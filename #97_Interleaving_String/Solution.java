public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	/* s1, s2 are both null*/
        if (s1 == null && s2 == null) {
        	return s3 == null;
        }
        /* only s1 is null */
        if (s1 == null) {
        	return s2.equals(s3);
        }
        /* only s2 is null */
        if (s2 == null) {
        	return s1.equals(s3);
        }
        /* s1, s2, s3 are not null */
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        /* length doesn't match */
        if (len1 + len2 != len3) return false;
        /* start dp */
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int j = 1; j < len2 + 1; j++) {
        	dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < len1 + 1; i++) {
        	dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < len1 + 1; i++) {
        	for (int j = 1; j < len2 + 1; j++) {
        		dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
	        		(dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        	}
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s1 = "aabcc";
    	String s2 = "dbbca";
    	String s3 = "aadbbcbcac";
    	String s4 = "aadbbbaccc";
    	System.out.println(sol.isInterleave(s1, s2, s3));
    	System.out.println(sol.isInterleave(s1, s2, s4));
    }
}