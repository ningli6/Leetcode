/* bfs */

import java.util.*;

public class BFS {
	static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList();
    	if (digits == null || digits.length() == 0) return queue;
        queue.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (queue.peek().length() == i) { // use length of element in the queue to control level
                String sb = queue.remove();
                int num = digits.charAt(i) - '0';
                for (char c : map[num - 2].toCharArray()) {
                    queue.add(sb + c);
                }
            }
        }
    	return queue;
    }

    public static void main(String[] args) {
    	BFS sol = new BFS();
    	List<String> re = sol.letterCombinations("23");
    	for(String s : re) {
    		System.out.println(s);
    	}
    }
}