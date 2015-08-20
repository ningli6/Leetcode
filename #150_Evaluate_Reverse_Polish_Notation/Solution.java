import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) 
        	return isOperator(tokens[0]) ? 0 : Integer.parseInt(tokens[0]);
        int len = tokens.length;
        Deque<Integer> stk = new LinkedList<Integer>();
        int result = -1;
        for (int i = 0; i < len; i++) {
        	String token = tokens[i];
        	if (isOperator(token)) {
        		int a = stk.pop();
        		int b = stk.pop();
        		result = compute(b, a, token);
        		// System.out.println("a :" + a + " b :" + b + " result: " + result);
        		stk.push(result);
        	}
        	else {
        		stk.push(Integer.parseInt(tokens[i]));
        	}
        }
        return result;
    }

    private boolean isOperator(String token) {
    	return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int compute(int a, int b, String opt) {
    	if (opt.equals("+")) return a + b;
    	if (opt.equals("-")) return a - b;
    	if (opt.equals("*")) return a * b;
    	if (opt.equals("/")) return a / b; 
    	return -1;
    }

    public static void main(String[] args) {
    	// Solution sol = new Solution();
    	// String[] tokens = {"4", "13", "5", "/", "+"};
    	// System.out.println(sol.evalRPN(tokens));
        System.out.println(6 / -132); 
    }
}