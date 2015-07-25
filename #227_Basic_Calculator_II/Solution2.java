import java.util.*;

/* Use stack to save previous result 
 * Much more elegent
 */
public class Solution2 {
    public int calculate(String s) {
    	if (s == null || s.length() == 0) return 0;
    	Deque<Long> stack = new LinkedList();
    	char sign = '+';
    	long num = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (Character.isDigit(s.charAt(i))) {
    			num = num * 10 + s.charAt(i) - '0';
    		}
    		if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
    			switch (sign) {
    				case '+':
    					stack.push(num);
    					break;
    				case '-':
    					stack.push(-num);
    					break;
    				case '*':
    					stack.push(stack.pop() * num);
    					break;
    				case '/':
    					stack.push(stack.pop() / num);
    					break;
    			}
    			sign = s.charAt(i);
    			num = 0;
    		}
    	}
    	long result = 0;
    	while (!stack.isEmpty()) {
    		result += stack.pop();
    	}
    	return (int) result;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
		System.out.println(sol.calculate("14/3*2"));
    }
}