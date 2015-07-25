import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() == 0) return result;
        if (wordDict == null || wordDict.isEmpty()) return result;
        int len = s.length();
        List<Integer>[] adj = (List<Integer>[]) new LinkedList[len + 1];
        for (int i = 0; i < len + 1; i++) {
        	adj[i] = new LinkedList<Integer>();
        }
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
        	for (int k = 0; k <= i; k++) {
        		if (dp[k] && wordDict.contains(s.substring(k, i + 1))) {
        			dp[i + 1] = true;
        			adj[k].add(i + 1);
        		}
        	}
        }
        if (!dp[len]) return result;
        StringBuilder sb = new StringBuilder();
        dfs(result, adj, sb, s, 0, len);
        return result;
    }

    private void dfs(List<String> result, List<Integer>[] adj, StringBuilder sb, String s, int index, int length) {
    	if (adj[index].isEmpty()) {
    		if (index == length) result.add(sb.toString().substring(0, sb.length() - 1));
    		return;
    	}
    	for (int i : adj[index]) {
    		// System.out.println(i);
    		sb.append(s.substring(index, i));
    		sb.append(" ");
    		dfs(result, adj, sb, s, i, length);
    		sb.delete(sb.length() - (i - index + 1), sb.length());
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "abcd";
    	Set<String> set = new HashSet<String>();
    	set.add("a"); set.add("abc"); set.add("b"); set.add("cd");
    	List<String> list = sol.wordBreak(s, set);
    	for (String str : list) {
    		System.out.println(str);
    	}
    }
}