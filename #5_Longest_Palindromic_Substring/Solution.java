public class Solution {
	int maxLength = 0;
    int start = -1; 
    int end = -1;
    public String longestPalindrome(String s) {
        if (s.length() == 0) return null;
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) {
        	expend(s, i, i);     // longest palindrome is odd
        	expend(s, i, i + 1); // longest palindrome is even
        }
        return s.substring(start, end);
    }

    private void expend(String s, int i, int j) {
    	int len = 0;
    	while (i >= 0 && j < s.length()) {
    		if (s.charAt(i) == s.charAt(j)) {
    			if (i == j) len += 1;
    			else len += 2;
    		}
    		else break;
			i--; j++;
    	}
    	if (len > maxLength) {
    		maxLength = len;
    		start = i + 1;
    		end = j;
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "aaaabbbc";
    	System.out.println(sol.longestPalindrome(s));
    }
}