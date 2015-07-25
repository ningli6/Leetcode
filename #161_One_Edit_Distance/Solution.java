public class Solution {
	public boolean isOneEditDistance(String s, String t) {
		if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) return false;
		if (s == null || s.length() == 0) {
			return (t.length() == 1) ? true : false;
		}
		if (t == null || t.length() == 0) {
			return (s.length() == 1) ? true : false;
		}
		int m = s.length();
		int n = t.length();
		if (Math.abs(m - n) > 1) return false;
		if (m > n) return isOneEditDistance(t, s);
		if (m == n) {
			int count = 0;
			int i = 0;
			while (i < m) {
				if (s.charAt(i) != t.charAt(i)) count++;
				i++;
			}
			return count == 1;
		}
		int i = 0; int j = 0;
		while(i < m && j < n) {
			if (s.charAt(i) != t.charAt(j)) j++;
			else {
				i++; j++;
			}
		}
		if (i == j && i == m) return true;
		if (i == m && j == n) return true;
		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isOneEditDistance("abc", "adc"));
	}
}