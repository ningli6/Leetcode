import java.util.*;

public class Solution {
	public static Map<Character, Integer> compute = new HashMap<Character, Integer>();
	static { compute.put('A',0); compute.put('C',1); compute.put('G',2); compute.put('T',3); }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() == 0 || s.length() <= 10) return result;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < s.length() - 9; i++) {
        	String sub = s.substring(i, i + 10);
        	int index = convert(sub);
        	if (!map.containsKey(index)) {
        		map.put(index, 1);
        	}
        	else {
        		if (map.get(index) < 2) result.add(sub);
        		map.put(index, map.get(index) + 1);
        	}
        }
        return result;
    }

    private static int convert(String s) {
    	int result = 0;
    	for (int i = 0; i < s.length(); i++) {
    		result = result * 4 + compute.get(s.charAt(i));
    	}
    	return result;
    }

    public static void main(String[] args) {
    	String s = "AAAAAAAAAAAA";
    	Solution sol = new Solution();
    	List<String> result = sol.findRepeatedDnaSequences(s);
    	for (String str : result) {
    		System.out.println(str);
    	}
    }
}