import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/* 
 * O(n) solution
 * Use a window to keep track of words in the set
 * Assume the length for each word in array words are len
 * We always step the length of len to include or remove word from window
 * We have to travel source String s for len times
 * For each travle, each word is mostly visited twice (left side of the window and right side of the window)
 * tiem complexity: 2 * s.length() / len * len
 */

public class Improved4 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> rslt = new LinkedList<Integer>();
		if (s.length() == 0 || words.length == 0 || s.length() < words.length * words[0].length()) return rslt;
		int len = words[0].length();
		HashMap<String, Integer> hist = new HashMap<String, Integer>();
		/* put all words from array in hashmap, each occur once */
		for (String w : words) hist.put(w, hist.containsKey(w) ? hist.get(w) + 1 : 1);
		/* start traverse */
		for (int i = 0; i < len; i++) {
			/* for each traverse, 
			 * we have left bound of window seated at position i
			 * we use another cur to record words in window
			 * we use count to judge if cur is identical to hist */
			int count = 0;
			int left = i;
			HashMap<String, Integer> cur = new HashMap<String, Integer>();
			/* traverse to the end of the string, note that step len each time */
			for (int j = i; j <= s.length() - len; j += len) {
				String tmp = s.substring(j, j + len);
				/* if tmp is in hist */
				if (hist.containsKey(tmp)) {
					cur.put(tmp, cur.containsKey(tmp) ? cur.get(tmp) + 1 : 1);
					/* if tmp is counted the same time as hist, it is then included in the window, increment count */
					if (cur.get(tmp) <= hist.get(tmp)) count++;
					else {
						/* now that tmp is counted more than it is in hist,
						 * we have to get rid of the duplicated one and
						 * remove every word before that */
						while (cur.get(tmp) > hist.get(tmp)) {
							String rm = s.substring(left, left + len);
							cur.put(rm, cur.get(rm) - 1);
							if (cur.get(rm) < hist.get(rm)) count--;
							left += len;
						}
					}
					/* if count is equals to size of words, job done
					 * note that we reuse this window and only remove the leftmost word
					 * and then try to expand the right bound */
					if (count == words.length) {
						rslt.add(left);
						String rm = s.substring(left, left + len);
						cur.put(rm, cur.get(rm) - 1);
						count--;
						left += len;
					}
				}
				/* if tmp is not in hist, reset everything */
				else {
					count = 0;
					left = j + len;
					cur.clear();
				}
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