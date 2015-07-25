public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int end = len; int start = len;
        int i = len - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i < 0) return 0;
        end = i + 1;
        while (i >= 0 && s.charAt(i) != ' ') i--;
        start = i + 1;
        return s.substring(start, end).length();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLastWord(" "));
    }
}