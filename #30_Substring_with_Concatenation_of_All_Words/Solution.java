import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> rslt = new ArrayList<Integer>();
		if (words.length == 0) return rslt;
		int len = words[0].length();
		for (String word : words) {
			List<Integer> indices = findOccurance(s, word);
			for (int i : indices) {
				// System.out.println(word + " " + i);
				HashSet<String> set = new HashSet<String>();
				for (String w : words) {
					if (!w.equals(word)) set.add(w);
				}
				search(s.substring(i + len), set, rslt, i, len);
			}
		}
		return rslt;
	}

	private void search(String s, HashSet<String> set, ArrayList<Integer> result, int position, int len) {
		if (set.isEmpty()) return;
		for (String word : set) {
			int index = s.indexOf(word);
			if (index == 0) {
				HashSet<String> subset = new HashSet<String>();
				for (String w : set) {
					if (!w.equals(word)) subset.add(w);
				}
				if (subset.isEmpty()) {
					result.add(position);
					return;
				}
				search(s.substring(len), subset, result, position, len);
			}
		}
	}

	private List<Integer> findOccurance(String s, String word) {
		List<Integer> result = new ArrayList<Integer>();
		if (word.length() > s.length()) return result;
		for (int i = 0; i < s.length() - word.length() + 1; i++) {
			int p = i;
			int q = 0;
			while (s.charAt(p) == word.charAt(q)) {
				p++; q++;
				if (q == word.length()) {
					result.add(i);
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// String s = "barfoothefoobarman";
		// String[] words = {"foo", "bar"};
		// Solution sol = new Solution();
		// List<Integer> list;
		// list = sol.findSubstring(s, words);
		// for (int i : list) {
		// 	System.out.println(i);
		// }
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		for (int i = 0; i < 5; ++i) {
			System.out.println(i);
		}

	}
}