import java.util.*;

public class Solution {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> ans = new LinkedList<List<String>>();
		if (strings.equals(null) || strings.length == 0) return ans;
		Arrays.sort(strings);
		Map<String, List<String>> key_list = new HashMap<String, List<String>>();
		for (String str : strings) {
			String key = hash(str);
			if (key_list.containsKey(key)) {
				key_list.get(key).add(str);
			} else {
				List<String> newList = new LinkedList<String>();
				newList.add(str);
				key_list.put(key, newList);
				ans.add(newList);
			}
		}
		return ans;
	}

	private String hash(String s) {
		if (s.equals(null) || s.equals("")) return "";
		int offset = s.charAt(0) - 'a';
		String key = "";
		for (int i = 0; i < s.length(); i++) {
			key += s.charAt(i) - offset < 'a' ? s.charAt(i) - offset + 26 : s.charAt(i) - offset;
		}
		return key;
	}

	public static void main(String[] args) {
		String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		Solution sol = new Solution();
		List<List<String>> re = sol.groupStrings(strs);
	}
}