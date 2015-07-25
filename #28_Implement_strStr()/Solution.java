/* KMP solution */
public class Solution {
    int R = 26;
    public int strStr(String haystack, String needle) {
    	/* corner case */
    	if (haystack == null || needle == null) return -1;
    	if (haystack.length() > 0 && needle.length() == 0) return 0;
    	if (haystack.length() == 0 && needle.length() == 0) return 0;
    	if (haystack.length() == 0) return -1;
        if (haystack.length() < needle.length()) return -1;
        int len = needle.length();
        int[][] dfa = new int[R][len];
        /* build dfa */
        dfa[needle.charAt(0) - 'a'][0] = 1;
        int prev = 0;
        for (int i = 1; i < len; i++) {
        	for (int j = 0; j < R; j++) dfa[j][i] = dfa[j][prev];
        	dfa[needle.charAt(i) - 'a'][i] = i x`+ 1;
	        prev = dfa[needle.charAt(i) - 'a'][prev];
        }
        /* start dfa */
        int i, j;
        for (i = 0; j = 0; i < haystack.length() && j < len; i++)
        	j = dfa[haystack.charAt(i) - 'a'][j];
        if (j == len) return i - len + 1;
        return -1;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.strStr("abcdef", "cdf"));
    }
}