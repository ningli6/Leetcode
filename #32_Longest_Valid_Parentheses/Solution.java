public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int[] a = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i < 2) a[i] = 2;
                    else a[i] = a[i - 2] + 2;
                }
                else // s.charAt(i - 1) == ')'
                {
                    int back = i - a[i - 1] - 1;
                    if (back >= 0 && s.charAt(back) == '(') {
                        if (back > 0) a[i] = a[i - 1] + 2 + a[back - 1];
                        else a[i] = a[i - 1] + 2;
                    }
                }
            }
        }
        int longest = 0;
        for (int i = len - 1; i >= 0; i--) {
            longest = (a[i] > longest) ? a[i] : longest;
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses(")()())()"));
    }
}