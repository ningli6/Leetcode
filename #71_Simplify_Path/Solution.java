import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
    	if (path == null || path.length() == 0) return null;
    	Deque<String> stk = new LinkedList<String>();
    	int iter = 1;
    	int prev = 1;
    	for (int i = iter; i < path.length(); i++) {
    		/* break if previous '/' has been out of string length range */
    		if (prev >= path.length()) break;
    		/* handle the case that path does not end with '/' */
    		if (i == path.length() - 1 && path.charAt(i) != '/') {
    			if (path.substring(prev, i + 1).equals("..")) {
    				if (!stk.isEmpty()) stk.pop();
    			}
    			else if (!path.substring(prev, i + 1).equals("."))
    				stk.push(path.substring(prev, i + 1));
    			break;
    		}
    		/* every time encounter '/', get substring in between */
    		if (path.charAt(i) == '/') {
    			/* pop if /../ */
    			if (path.charAt(i - 1) != '/' && path.substring(prev, i).equals("..")) {
    				 if (!stk.isEmpty()) stk.pop();
    			}
    			/* ignore /. */
    			else if (path.charAt(i - 1) != '/' && !path.substring(prev, i).equals(".")) {
    				stk.push(path.substring(prev, i));
    			}
	    		prev = i + 1;
    		}
    	}
    	if (stk.isEmpty()) return "/";
    	/* reconstruct simplified path */
    	Object[] p = stk.toArray();
    	StringBuilder sb = new StringBuilder();
    	for (int i = p.length - 1; i >= 0; i--) {
    		sb.append("/");
    		sb.append(p[i]);
    	}
    	return sb.toString();
    }

    public static void main(String[] args) {
    	String path = "/..";
    	Solution sol = new Solution();
    	System.out.println(sol.simplifyPath(path));
    }
}