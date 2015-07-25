public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        String str = s.toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i <= j) {
        	if ((str.charAt(i) < 'a' || str.charAt(i) > 'z') && (str.charAt(i) < '0' || str.charAt(i) > '9')) i++;
        	else if ((str.charAt(j) < 'a' || str.charAt(j) > 'z') && (str.charAt(j) < '0' || str.charAt(j) > '9')) j--;
        	else if (str.charAt(i) == str.charAt(j)) {
        		i++; j--;
        	}
        	else return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isPalindrome("1a2"));
    }
}