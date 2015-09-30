/* KMP based O(n) solution */

public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        StringBuilder sb = new StringBuilder(s).append(new StringBuilder(s).reverse());
        System.out.println(sb.toString());
        int[] p = new int[sb.length()];
        for (int i = 1; i < sb.length(); i++) {
            int k = p[i - 1];
            while (sb.charAt(i) != sb.charAt(k)) {
                if (k == 0) break;
                k = p[k - 1];
            }
            p[i] = (sb.charAt(i) == sb.charAt(k)) ? k + 1 : k;
        }
        for (int j = 0; j < p.length; j++) {
            System.out.print(p[j] + " ");
        }
        System.out.println();
        return new StringBuilder(s.substring(p[sb.length() - 1])).reverse().append(s).toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.shortestPalindrome("aaab"));
    }
}