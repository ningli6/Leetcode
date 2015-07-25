import java.util.Arrays;

public class Solution {
    public boolean isScramble(String s1, String s2) {
    	/* length 0 */
    	if (s1.length() == 0 || s2.length() == 0) return false;
    	/* different length */
    	if (s1.length() != s2.length()) return false;
    	/* single char not equal */
    	if (s1.length() == 1 && !s1.equals(s2)) return false;
    	/* exact same */
    	if (s1.equals(s2)) return true;
        if (!checkChar(s1, s2)) return false;
    	int len = s1.length();
        for (int i = 1; i < len; i++) {
            /* not reverse */
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            /* reverse */
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i))) return true;
        }
        return false;
    }

    private boolean checkChar(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        Arrays.sort(sc1);
        Arrays.sort(sc2);
        String ns1 = new String(sc1);
        String ns2 = new String(sc2);
        return ns1.equals(ns2);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isScramble("great", "rgtae"));
    }
}