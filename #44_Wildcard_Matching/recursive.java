/* Recursive method
 * Not efficient enough, exceeds time limits
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == p) return true;
        if (p.equals("*")) return true;
        int ps = 0;
        int pp = 0;
        if (s.length() == 0) {
            if (p.length() == 0) return true;
            else {
                while(p.charAt(pp) == '*') {
                    pp++;
                    if (pp == p.length()) return true;
                }
                return false;
            }
        }
        for (; pp < p.length(); pp++) {
            char c = p.charAt(pp);
            if (c == '?') ps++; // ?
            else if (c != '*') { // a-zA-Z
                if (s.charAt(ps) == c) ps++;
                else return false;
            }
            else { // *
                if (pp == p.length() - 1) return true;
                while(p.charAt(pp) == '*') {
                    pp++;
                    if (pp == p.length()) return true;
                }
                for (; ps < s.length(); ps++) {
                    if (s.charAt(ps) == p.charAt(pp)) {
                        return isMatch(s.substring(ps), p.substring(pp));
                    }
                }
                return false;
            }
            if (ps == s.length()) {
                pp++;
                break;
            }
        }
        if (ps == s.length() && pp == p.length()) return true;
        else if (ps < s.length()) return false;
        else if (pp < p.length()) {
            while(p.charAt(pp) == '*') {
                pp++;
                if (pp == p.length()) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aaaaaaa", "aaaaa*"));
    }
}