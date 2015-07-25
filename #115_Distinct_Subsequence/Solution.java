public class Solution {
    public int numDistinct(String s, String t) {
        // System.out.println(s + ", " + t);
        int sum = 0;
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0 && tlen == 0) return 1;
        if (slen == 0) return 0;
        if (tlen == 0) return 1;
        if (s.equals(t)) return 1;
        if (tlen > slen) return 0;
        for (int i = 0; i < slen - tlen + 1; i++) {
            System.out.println("i: " + i);
            if (s.charAt(i) == t.charAt(0)) sum += numDistinct(s.substring(i + 1), t.substring(1));
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ccc";
        String t = "c";
        System.out.println(sol.numDistinct(s, t));
    }
}