import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        while (i <= j && j < s.length()) {
        	char c = s.charAt(j);
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        		j++;
        		result = Math.max(result, j - i);
        		continue;
        	}
        	// new char
        	if (map.size() < 2) { // still able to add new char to set
        		map.put(c, 1);
        		j++;
        		result = Math.max(result, j - i);
        		continue;
        	}
        	// 3 chars in string, increment ptr i
        	char d = s.charAt(i);
        	map.put(d, map.get(d) - 1);
        	if (map.get(d) == 0) map.remove(d);
        	i++;
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "ecebc";
    	System.out.println(sol.lengthOfLongestSubstringTwoDistinct(s));
    }
}