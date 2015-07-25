import java.util.*;
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char cs = s.charAt(i);
        	char ct = t.charAt(i);
        	if (!map.containsKey(cs)) {
        		if (!set.contains(ct)) {
        			map.put(cs, ct);
        			set.add(ct);
        		}
        		else return false;
        	}
        	else {
        		char cget = map.get(cs);
        		if (cget != ct) return false;
        	}
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isIsomorphic("ab", "aa"));
    }
}