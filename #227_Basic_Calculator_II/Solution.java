public class Solution {

	int index;

    public int calculate(String s) {
    	String str = trimSpace(s);
    	if (str == null || str.length() == 0) return 0;
    	index = 0;
    	int length = str.length();
    	long sum = 0;
    	boolean negative = false;
    	while (index < length) {
    		int start = index;
    		while (index < length && isDigit(str.charAt(index))) index++;
    		if (index != start) { // find a number
    			long num = Long.valueOf(str.substring(start, index));
    			if (index == length) return (negative) ? (int) (sum - num) : (int) (sum + num);
    			if (str.charAt(index) == '*' || str.charAt(index) == '/') { // multiplication / division
    				index = start;
    				sum = (negative) ? sum - multdiv(str) : sum + multdiv(str);
    			}
    			else sum = (negative) ? sum - num : sum + num;
    			negative = false;
    			continue;
    		}
    		if (str.charAt(index) == '-') negative = true;
    		index++;
    	}
    	return (int) sum;
    }

    private long multdiv(String string) {
    	if (string == null || string.length() == 0) return 0;
    	long result = 1;
    	boolean div = false;
    	while (true) {
    		int start = index;
    		while (index < string.length() && isDigit(string.charAt(index))) index++;
    		long num = Long.valueOf(string.substring(start, index));
    		result = (div) ? result / num : result * num;
    		div = false;
    		if (index == string.length() || string.charAt(index) == '+' || string.charAt(index) == '-') return result;
    		if (string.charAt(index) == '/') div = true;
			index++;
    	}
    }

    private String trimSpace(String s) {
    	if (s == null || s.length() == 0) return s;
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) != ' ') sb.append(s.charAt(i));
    	}
    	return sb.toString();
    }

    private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.calculate("14/3*2"));
	}
}