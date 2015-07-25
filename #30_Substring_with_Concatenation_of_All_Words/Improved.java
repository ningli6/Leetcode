import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class Improved {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> rslt = new LinkedList<Integer>();
		if (s.length() == 0 || words.length == 0) return rslt;
		HashSet<String> set = new HashSet<String>();
		for (String word : words) set.add(word);
		int len = words[0].length();
		for (int i = 0; i <= s.length() - len * words.length; i++) {
			String tmp = s.substring(i, i + len);
			if (set.contains(tmp)) {
				HashSet<String> cmp = new HashSet<String>();
				for (int j = 0; j < words.length; j++) {
					String candi = s.substring(i + j * len, i + len + j * len);
					if (!set.contains(candi)) break;
					cmp.add(candi);
				}
				if (cmp.equals(set)) rslt.add(i);
			}
		}
		return rslt;
	}
	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		Solution sol = new Solution();
		List<Integer> list;
		list = sol.findSubstring(s, words);
		for (int i : list) {
			System.out.println(i);
		}
	}
}