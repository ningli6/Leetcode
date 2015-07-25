import java.util.*;

// For the last line of text, it should be left justified and no extra space is inserted between words.

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> result = new LinkedList();
    	if (words == null || words.length == 0) return result;
    	int s = 0; int e = 0;
    	int len = words.length;
    	while (s < len && e < len) {
    		int sumLen = 0;
    		while(e < len && sumLen + words[e].length() <= maxWidth) {
    			sumLen += words[e].length() + 1;
    			e++;
    		}
    		sumLen -= 1; // the last word does not need a following space
    		/* [s, e) */
			int space = maxWidth - sumLen;
			int spaceinBetween = 0, addon = 0;
			if ((e - s - 1) == 0) { // special case: only have one word
				spaceinBetween = space;
			}
			else {
				spaceinBetween = space / (e - s - 1);
				addon = space % (e - s - 1);
			}
			StringBuilder sb = new StringBuilder();
			if (e == len) { // last line
				for (int i = s; i < e; i++) {
					sb.append(words[i]);
					if (i != e - 1) sb.append(' '); // append space if is not the last word
				}
				for (int j = 0; j < space; j++) sb.append(' ');
			}
			else {
				for (int i = s; i < e; i++) {
					if (e - s == 1) { // only one word
						sb.append(words[i]);
						for (int j = 0; j < space; j++) sb.append(' ');
					}
					else {
						sb.append(words[i]);
						if (i == e - 1) continue; // the last word, break
						sb.append(' ');
						for (int j = 0; j < spaceinBetween; j++) sb.append(' ');
						if (addon > 0) {
							sb.append(' ');
							addon--;
						}
					}
				}
			}
			result.add(sb.toString());
			s = e;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    	List<String> result = sol.fullJustify(words, 16);
    	for (String str : result) {
    		System.out.println(str + "|");
    	}
    }
}