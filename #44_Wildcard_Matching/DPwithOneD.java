public class DPwithOneD {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) return s.length() == 0;
		boolean[] dp = new boolean[p.length() + 1];
		dp[0] = true;
		for (int j = 1; j <= p.length(); j++) {
			if (p.charAt(j - 1) == '*') dp[j] = dp[j - 1];
		}
		for (int i = 1; i <= s.length(); i++) {
			boolean[] tmp = new boolean[p.length() + 1];
			for (int j = 1; j <= p.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					tmp[j] = dp[j - 1];
				}
				if (p.charAt(j - 1) == '*') {
					tmp[j] = tmp[j - 1] || dp[j];
				}
			}
			dp = tmp;
		}
		return dp[p.length()];
	}

	public static void main(String[] args) {
		DPwithOneD test = new DPwithOneD();
		System.out.println(test.isMatch("abc", "a*b"));
	}
}