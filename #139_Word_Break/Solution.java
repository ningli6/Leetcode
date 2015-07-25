import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        if (wordDict == null || wordDict.isEmpty()) return false;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
        	for (int k = 0; k <= i; k++) {
        		if (dp[k] && wordDict.contains(s.substring(k, i + 1))) {
        			dp[i + 1] = true;
        			break;
        		}
        	}
        }
        return dp[len];        
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "leetcode";
    	Set<String> set = new HashSet<String>();
    	set.add("leet"); set.add("code");
    	System.out.println(sol.wordBreak(s, set));
    }
}