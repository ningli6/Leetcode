/* use a dp matrix */
public class Improved {
    public int numDistinct(String s, String t) {
    	int slen = s.length();
    	int tlen = t.length();
    	/* both empty */
    	if (slen == 0 && tlen == 0) return 1;
    	/* s is empty but t is not */
    	if (slen == 0) return 0;
    	/* t is empty but s is not */
    	if (tlen == 0) return 1;
    	/* both not empty */
    	int[][] dp = new int[tlen + 1][slen + 1];
    	/* initialize */
    	for (int j = 0; j < slen + 1; j++) dp[0][j] = 1;
    	/* begin dp */
    	for (int i = 1; i < tlen + 1; i++) {
    		for (int j = i; j < slen + 1; j++) {
    			if (t.charAt(i - 1) != s.charAt(j - 1)) dp[i][j] = dp[i][j - 1];
    			else dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
    		}
    	}
    	return dp[tlen][slen];
    }

    public static void main(String[] args) {
        Improved sol = new Improved();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(sol.numDistinct(s, t));
    }
}