import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static List<String> anagrams(String[] strs) {
        List<String> result = new LinkedList<String>();
        if (strs.length == 0) return result;
        int len = strs.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] sortedStr = new String[len];
        for (int i = 0; i < len; i++) {
        	String sorted = sort(strs[i]);
        	sortedStr[i] = sorted;
        	map.put(sorted, map.containsKey(sorted) ? (map.get(sorted) + 1) : 0);
        }
        for (int i = 0; i < len; i++) {
        	if (map.get(sortedStr[i]) > 0) result.add(strs[i]);
        }
        return result;
    }

    private static String sort(String str) {
    	char[] a = str.toCharArray();
    	Arrays.sort(a);
    	return String.valueOf(a);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] test = {"god", "dog", "ear", "are", "you", "pi", "ip", "string"};
    	List<String> list = sol.anagrams(test);
    	for (String str : list) {
    		System.out.println(str);
    	}
    }
}