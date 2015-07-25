import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Improved2 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> rslt = new LinkedList<Integer>();
		if (s.length() == 0 || words.length == 0) return rslt;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
		int len = words[0].length();
		for (int i = 0; i <= s.length() - len * words.length; i++) {
			String tmp = s.substring(i, i + len);
			if (map.containsKey(tmp)) {
				Map<String, Integer> cur = new HashMap<String, Integer>();
				for (int j = 0; j < words.length; j++) {
					String candi = s.substring(i + j * len, i + len + j * len);
					cur.put(candi, cur.containsKey(candi) ? cur.get(candi) + 1 : 1);
				}
				if (cur.equals(map)) rslt.add(i);
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