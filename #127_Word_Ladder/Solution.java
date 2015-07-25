import java.util.Deque;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord.equals(endWord)) return 0;
        if (wordDict.isEmpty()) return 0;
        int len = beginWord.length();
        if (len == 1) {
        	if (wordDict.contains(beginWord) && wordDict.contains(endWord)) return 2;
        	return 0;
        }
        int level = 1;
        int prevLeveSize = 1;
        int nextLeveSize = 0;
        Deque<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
        	prevLeveSize--;
        	String str = queue.remove();
        	char[] charOfStr = str.toCharArray();
        	for (int index = 0; index < len; index++) {
	        	char tmpChar = charOfStr[index];
        		for (char c = 'a'; c <= 'z'; c++) {
        			if (c == tmpChar) continue;
        			charOfStr[index] = c;
        			String tmp = new String(charOfStr);
        			if (tmp.equals(endWord)) {
        				return level + 1;
        			}
        			if (!visited.contains(tmp) && wordDict.contains(tmp)) {
    					nextLeveSize++;
        				visited.add(tmp);
        				queue.add(tmp);
        			}
        			charOfStr[index] = tmpChar;
        		}
        	}
        	if (prevLeveSize == 0) {
        		level++;
        		prevLeveSize = nextLeveSize;
        		nextLeveSize = 0;
        	}
        }
        return 0;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String start = "hit";
    	String end = "cog";
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	System.out.println(sol.ladderLength(start, end, dict));
    }
}