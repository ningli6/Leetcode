public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (numRows == 0) return null;
        if (s == null || s.length() == 0) return s;
        int size = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
        	for (int j = i; j < s.length(); j += size) {
        		sb.append(s.charAt(j));
        		if (i != 0 && i != numRows - 1 && j + size - 2 * i < s.length()) {
        			sb.append(s.charAt(j + size - 2 * i));
        		}
        	}
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("0123456789abcd", 4));
    }
}