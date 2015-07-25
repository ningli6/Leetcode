import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

/* backtracing takes O(2^N) time
 * could be slightly imporved by using dp to keep track of palindrome 
 */

public class Solution {
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return null;
        List<List<String>> result = new LinkedList<List<String>>();
        LinkedList<String> list = new LinkedList<String>();
        partition(s, result, list);
        return result;
    }

    private static void partition(String s, List<List<String>> result, LinkedList<String> list) {
    	if (s.length() == 0 || s == null) return;
    	for (int i = 1; i <= s.length(); i++) {
    		if (isPalindrome(s.substring(0, i))) {
    			list.add(s.substring(0, i));
    			if (i == s.length()) {
    				result.add(new LinkedList<String>(list));
    			}
    			else partition(s.substring(i), result, list);
    			list.removeLast();
    		}
    	}
    }

    private static boolean isPalindrome(String s) {
    	if (s == null || s.length() == 0) return false;
    	if (s.length() == 1) return true;
    	int len = s.length();
    	int start = 0; int end = len - 1;
    	while (true) {
    		if (s.charAt(start) != s.charAt(end)) return false;
    		start++; end--;
    		if (start >= end) break;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<String>> result = new LinkedList<List<String>>();
    	result = sol.partition("aab");
    	// System.out.println(result.size());
    	for (List<String> list : result) {
    		for (String str : list) {
    			System.out.print(str + " ");
    		}
    		System.out.println();
    	}
    }
}