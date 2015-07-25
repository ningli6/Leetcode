import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
    	String result = "";
    	if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length())
			return result;    		
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
        	if (!map.containsKey(t.charAt(i))) map.put(t.charAt(i), 1);
        	else map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
        }
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        int i = 0, j = 0, minL = Integer.MAX_VALUE;
        int match = 0;
        while (i < s.length() && j < s.length()) {
        	if (map.containsKey(s.charAt(j))) {
        		if (window.containsKey(s.charAt(j))) 
        			window.put(s.charAt(j), window.get(s.charAt(j)) + 1);
        		else window.put(s.charAt(j), 1);
        		if (window.get(s.charAt(j)) <= map.get(s.charAt(j))) match++;
        	}
        	j++;
        	while (i < s.length() && match == t.length()) {
        		if (j - i < minL) {
        			minL = j - i;
        			result = s.substring(i, j);
        		}
        		if (!map.containsKey(s.charAt(i))) {
        			i++;
        			continue;
        		}
        		if (window.get(s.charAt(i)) >= map.get(s.charAt(i))) {
        			if (window.get(s.charAt(i)) == 1) window.remove(s.charAt(i));
    				else window.put(s.charAt(i), window.get(s.charAt(i)) - 1);
        		}
        		if (!window.containsKey(s.charAt(i)) || window.get(s.charAt(i)) < map.get(s.charAt(i))) match--;
    			i++;
        	}
        }
    	return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	// System.out.println(sol.minWindow("a", "aa"));
    	// System.out.println(sol.minWindow("aa", "aa"));
    	// System.out.println(sol.minWindow("ab", "a"));
		// System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(sol.minWindow("acbbaca", "aba"));
    }
}