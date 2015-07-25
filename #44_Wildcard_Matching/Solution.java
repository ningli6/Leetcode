/* Greedy algorithm */
public class Solution {
	public boolean isMatch(String s, String p) {
		// if p.length is 0, return true only if s.length is 0 too
		if (p.length() == 0) return s.length() == 0;
		// index for s, index for p, check point for s, check point for p
		int is = 0, ip = 0, cs = -1, cp = -1;
		while(ip < p.length()) { // ip iterate chars in p
			// match
			if (is < s.length() && (s.charAt(is) == p.charAt(ip) || p.charAt(ip) == '?')) is++;
			// *, save check point
			else if (is < s.length() && p.charAt(ip) == '*') {
				cp = ip;
				cs = is;
			}
			// not match and no previous *
			else if (is < s.length() && cp < 0) return false;
			// not match but has previous *, return to it
			else if (is < s.length() && (cp >= 0)) {
				ip = cp;
				is = cs++;
			}
			else break; // if is reach the end of s, break loop
			ip++;
			if (is < s.length() && ip == p.length() && cp >= 0) {
				ip = cp + 1;
				is = cs++;
			}
		}
		// s is not over, p is over
		if (is < s.length() && ip == p.length()) return p.charAt(ip - 1) == '*';
		// s and p are both over
		if (is == s.length() && ip == p.length()) return true;
		// s is over but p is not over
		while(ip < p.length()) {
			if (p.charAt(ip) != '*') return false;
			ip++;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isMatch("hi", "*?"));
	}
}