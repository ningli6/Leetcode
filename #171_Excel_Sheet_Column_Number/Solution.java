public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.titleToNumber("AA"));
    }
}