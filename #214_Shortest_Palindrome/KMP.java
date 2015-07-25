public class KMP {

	public int[] countPrefixSuffix(String str) {
		int[] p = new int[str.length()];
		for (int i = 1; i < str.length(); i++) {
			int k = p[i - 1];
			while (str.charAt(i) != str.charAt(k)) {
				if (k == 0) break;
				k = p[k - 1];
			}
			p[i] = (str.charAt(i) == str.charAt(k)) ? k + 1 : k;
		}
		return p;
	}

	public int[] next(String str) {
		int[] p = new int[str.length()];
		p[0] = -1;
		for (int i = 1; i < str.length(); i++) {
			int k = p[i - 1];
			while (k != -1 && str.charAt(k) != str.charAt(i - 1)) {
				k = p[k];
			}
			if (k != -1) p[i] = (str.charAt(k) == str.charAt(i - 1)) ? k + 1 : k;
			else p[i] = 0;
		}
		return p;
	}

	public static void main(String[] args) {
		KMP kmp = new KMP();
		String s = "abcdabd";
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + " ");
		}
		System.out.println();
		int[] result = kmp.countPrefixSuffix(s);
		for (int it : result) {
			System.out.print(it + " ");
		}
		System.out.println();
		result = kmp.next(s);
		for (int it : result) {
			System.out.print(it + " ");
		}
		System.out.println();
	}
}