public class Solution {

	int cur;

	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
		cur = 0;
		/* get rid of spaces */
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') sb.append(s.charAt(i));
		}
		String str = sb.toString();
		return eval(str);
	}

	// return the index that have been processed
	private int eval(String str) {
		if (str == null || str.length() == 0) return 0;
		if (cur >= str.length()) return 0;
		int sum = 0;
		boolean negative = false;
		while (cur < str.length()) {
			int s = cur;
			int e = s;
			while (e < str.length() && isDigit(str.charAt(e))) e++;
			if (s != e) {
				if (negative) sum -= Integer.valueOf(str.substring(s, e));
				else sum += Integer.valueOf(str.substring(s, e));
				negative = false;
				cur = e;
				continue;
			} // s == e
			if (str.charAt(e) == '(') {
				cur++;
				if (negative) sum -= eval(str);
				else sum += eval(str);
				negative = false;
				continue;
			}
			if (str.charAt(e) == ')') {
				cur = e + 1;
				return sum;
			}
			if (str.charAt(e) == '-') negative = true;
			cur++;
		}
		return sum;
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.calculate("(7) - (1) + (1)"));
	}
}