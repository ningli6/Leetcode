import java.util.List;
import java.util.LinkedList;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        int len = s.length();
        if (len == 0) return result;
        StringBuilder sb = new StringBuilder();
        backtracing(result, s, sb, 0);
        return result;
    }

    private void backtracing(List<String> result, String s, StringBuilder sb, int level) {
    	if (s.length() == 0) return;
    	if (level == 3) {
    		if (valid(s)) {
    			sb.append(s);
    			result.add(sb.toString());
    			sb.delete(sb.length() - s.length(), sb.length());
    		}
    		return;
    	}
    	for (int i = 0; i < 3 && i < s.length(); i++) {
    		if (valid(s.substring(0, i + 1))) {
    			sb.append(s.substring(0, i + 1));
    			sb.append(".");
    			backtracing(result, s.substring(i + 1), sb, level + 1);
    			sb.delete(sb.length() - (i + 2), sb.length());
    		}
    	}
    }

    private boolean valid(String s) {
    	if (s == null) return false;
    	int len = s.length();
    	if (len <= 0 || len > 3) return false;
    	int val = Integer.parseInt(s);
    	if (val < 0 || val > 255) return false;
    	/* do not allow leading 0s */
    	if (s.charAt(0) == '0' && val != 0) return false;
    	/* do not allow all 0s */
    	if (len > 1 && val == 0) return false;
    	return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<String> list = sol.restoreIpAddresses("010010");
    	for (String str : list) {
    		System.out.println(str);
    	}
    }

}
