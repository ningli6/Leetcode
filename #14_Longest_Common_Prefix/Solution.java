public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i = 0; // length of lcp
        for (; i < strs[0].length(); i++)
        	for (int j = 1; j < strs.length; j++)
        		if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) return strs[0].substring(0, i);
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] strs = {"aa", "a"};
    	System.out.println(sol.longestCommonPrefix(strs));
    }
}