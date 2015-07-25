public class Solution {
    public String convertToTitle(int n) {
        if (n < 0) throw new IllegalArgumentException();
        StringBuilder result = new StringBuilder();
        while(n > 0) {
        	int quotient = (n - 1) / 26;
        	int reminder = n - 26 * quotient;
        	int c = 'A' + reminder - 1;
        	result.append((char)c);
        	n = quotient;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.convertToTitle(702));
    	System.out.println(sol.convertToTitle(703));
    }
}