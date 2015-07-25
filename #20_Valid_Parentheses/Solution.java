import java.util.*;

public class Solution {
    public boolean isValid(String s) {
    	Deque<Character> stk = new LinkedList<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (c == '(' || c == '{' || c == '[') stk.push(c);
    		else {
    			if (stk.isEmpty()) return false;
    			char p = stk.pop();
    			if (p != '{' && c == '}') return false;
    			if (p != '(' && c == ')') return false;
    			if (p != '[' && c == ']') return false;
    		}
    	}
    	return stk.isEmpty();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "{[}]";
    	System.out.println(sol.isValid(s));
    }
}