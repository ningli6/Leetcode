import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        bt(result, sb, n, n);
        return result;
    }

    private void bt(List<String> result, StringBuilder sb, int left, int right) {
    	// System.out.println("left: " + left + " , right: " + right);
    	// System.out.println(sb.toString());
    	if (left > right) return;
    	if (left == 0 && right == 0) {
    		result.add(sb.toString());
    		return;
    	}
    	if (left > 0) {
    		bt(result, sb.append('('), left - 1, right);
	    	sb.delete(sb.length() - 1, sb.length());
    	}
    	if (right > 0) {
    		bt(result, sb.append(')'), left, right - 1);
	    	sb.delete(sb.length() - 1, sb.length());
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<String> result = sol.generateParenthesis(3);
    	for (String s : result) {
    		System.out.println(s);
    	}
    }
}