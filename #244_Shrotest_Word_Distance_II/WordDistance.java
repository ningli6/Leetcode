/**
 * O(n ^ 2) initialization doesn't work, even though it has O(1) response time
 */

import java.util.*;

public class WordDistance {

	HashMap<String, HashMap<String, Integer>> wordsDic;

    public WordDistance(String[] words) {
        wordsDic = new HashMap<String, HashMap<String, Integer>>();
        for (int i = 0; i < words.length - 1; i++) {
        	for (int j = i + 1; j < words.length; j++) {
        		if (!wordsDic.containsKey(words[i])) {
        			wordsDic.put(words[i], new HashMap<String, Integer>());
        		}
        		if (!wordsDic.containsKey(words[j])) {
        			wordsDic.put(words[j], new HashMap<String, Integer>());
        		}
        		int dist = j - i;
        		HashMap<String, Integer> iMap = wordsDic.get(words[i]);
        		HashMap<String, Integer> jMap = wordsDic.get(words[j]);
        		if (iMap.containsKey(words[j])) {
        			dist = Math.min(dist, iMap.get(words[j]));
        		}
        		if (jMap.containsKey(words[i])) {
        			dist = Math.min(dist, jMap.get(words[i]));
        		}
        		iMap.put(words[j], dist);
        		jMap.put(words[i], dist);
        	}
        }
    }

    public int shortest(String word1, String word2) {
        return wordsDic.get(word1).get(word2);
    }

    public static void main(String[] args) {
    	String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    	WordDistance wd = new WordDistance(words);
    	System.out.println(wd.shortest("practice", "coding"));
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");