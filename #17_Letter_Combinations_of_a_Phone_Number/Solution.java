/* dfs */

import java.util.*;

public class Solution {
	static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
    	List<String> result = new LinkedList();
    	if (digits == null || digits.length() == 0) return result;
    	StringBuilder sb = new StringBuilder();
    	bt(digits, sb, result);
    	return result;
    }

    private void bt(String s, StringBuilder sb, List<String> result) {
    	if (s == null || s.length() == 0) return;
    	int num = s.charAt(0) - '0';
    	if (num < 2) return;
    	for (char c : map[num - 2].toCharArray()) {
    		sb.append(c);
    		if (s.length() == 1) result.add(sb.toString());
    		bt(s.substring(1, s.length()), sb, result);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<String> re = sol.letterCombinations("23");
    	for(String s : re) {
    		System.out.println(s);
    	}
    }
}