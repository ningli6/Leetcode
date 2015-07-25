public class Solution {
    public String reverseWords(String s) {
    	if (s.length() == 0 || s == null) return s;
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1; int start = end;
        for (int e = end; e >= 0; e--) {
        	if (s.charAt(e) == ' ') continue;
        	end = e;
        	start = e;
        	while(start >= 0 && s.charAt(start) != ' ') start--;
        	sb.append(s.substring(start + 1, end + 1));
        	sb.append(" ");
        	e = start;
        }
        if (sb.length() > 0) sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.reverseWords(" "));
    }
}