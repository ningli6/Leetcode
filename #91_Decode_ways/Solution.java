public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        if (s.length() == 2) {
            if (Integer.parseInt(s) > 26) return 1;
            return 2;
        } 
        String a = s.substring(0, 2);
        if (Integer.parseInt(a) <= 26) return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        return numDecodings(s.substring(1));
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.numDecodings("123"));
    }
}