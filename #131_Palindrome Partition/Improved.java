import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

/* backtracing takes O(2^N) time
 * could be slightly imporved by using dp to keep track of palindrome 
 */

public class Improved {
    public static List<List<String>> partition(String s) {
        if (s.length() == 0) return null;
        List<List<String>> result = new LinkedList<List<String>>();
        LinkedList<String> list = new LinkedList<String>();
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = 0; i <= len; i++) dp[i][i] = true;
        for (int j = 0; j <= len; j++) {
            for (int i = 0; i < j; i++) {
                if (j == i + 1) dp[i][j] = true;
                else {
                    dp[i][j] = (dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j - 1));
                }
            }
        }
        partition(s, 0, len, result, list, dp);
        return result;
    }

    private static void partition(String s, int start, int end, List<List<String>> result, LinkedList<String> list, boolean[][] dp) {
    	if (s.length() == 0) return;
    	for (int i = start + 1; i <= s.length(); i++) {
    		if (dp[start][i]) {
    			list.add(s.substring(start, i));
    			if (i == s.length()) {
    				result.add(new LinkedList<String>(list));
    			}
    			else partition(s, i, s.length(), result, list, dp);
    			list.removeLast();
    		}
    	}
    }

    public static void main(String[] args) {
    	Improved sol = new Improved();
    	List<List<String>> result = new LinkedList<List<String>>();
    	result = sol.partition("aab");
    	// System.out.println(result.size());
    	for (List<String> list : result) {
    		for (String str : list) {
    			System.out.print(str + " ");
    		}
    		System.out.println();
    	}
    }
}