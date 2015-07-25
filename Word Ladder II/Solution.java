import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;

public class Solution {
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new LinkedList<List<String>>();
		if (start.equals(end)) return result;
		if (dict.isEmpty()) return result;
		int len = start.length();
		if (len == 1) {
			if (dict.contains(start) && dict.contains(end)) {
				List<String> str = new LinkedList<String>();
				str.add(start); str.add(end);
				result.add(str);
			}
			return result;
		}
		/* keep track of level information */
		int level = 1;
		int prevLeveSize = 1;
		int nextLeveSize = 0;
		/* remember at which level is this string visited */
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		visited.put(start, level);
		/* remember the ending string for each list */
		HashMap<String, List<List<String>>> listMap = new HashMap<String, List<List<String>>>();
		List<String> origin = new LinkedList<String>(); 
		origin.add(start);
		List<List<String>> originLists = new LinkedList<List<String>>();
		originLists.add(origin);
		listMap.put(start, originLists);
		/* queue for bfs */
		Deque<String> queue = new LinkedList<String>();
		queue.add(start);
		int minLen = Integer.MAX_VALUE;
		/* BFS */
		while (!queue.isEmpty()) {
			prevLeveSize--;
			String str = queue.remove();
			// System.out.println("Pop: " + str);
			char[] charOfStr = str.toCharArray();
			List<List<String>> lists = listMap.get(str);
			/* I want to see lists */
			// System.out.println("List ending with " + str);
			// for (List<String> list : lists) {
			// 	for (String string : list) {
			// 		// System.out.print(string + " ");
			// 	}
			// 	// System.out.println();
			// }
			int prevLen = lists.get(0).size();
			if (prevLen >= minLen) continue;
			for (int index = 0; index < len; index++) {
				char tmpChar = charOfStr[index];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == tmpChar) continue;
					charOfStr[index] = c;
					String tmp = new String(charOfStr);
					/* tmp equals to end */
					if (tmp.equals(end)) {
						// System.out.print("Find: " + tmp);
						// System.out.println(" Search hit!");
						int curLen = lists.get(0).size();
						if (curLen == prevLen) {
							for (List<String> list : lists) {
								list.add(tmp);
								result.add(list);
								minLen = list.size();
							}
						}
						else {
							for (List<String> list : lists) {
								List<String> newList = new LinkedList<String>(list);
								newList.remove(list.size() - 1);
								newList.add(tmp);
								result.add(newList);
								minLen = newList.size();
							}
						}
						// System.out.println("***Result***");
						// for (List<String> list : result) {
						// 	for (String nstr : list) {
						// 		// System.out.print(nstr + " ");
						// 	}
						// 	// System.out.println();
						// }
						// System.out.println("************");
					}
					/* tmp not equal to end */
					else {
						if (dict.contains(tmp) && (!visited.containsKey(tmp) || (visited.get(tmp) == level))) {
							nextLeveSize++;
							queue.add(tmp);
							// System.out.println("Find: " + tmp);
							int curLen = lists.get(0).size();
							if (!visited.containsKey(tmp)) {
								if (curLen == prevLen) {
									for (List<String> list : lists) {
										list.add(tmp);
									}
									listMap.put(tmp, lists);
								}
								else {
		        					// deep copy
									// System.out.println("Make a deep copy");
									LinkedList<List<String>> newLists = new LinkedList<List<String>>();
									for (List<String> list : lists) {
										List<String> newList = new LinkedList<String>(list);
										newList.remove(list.size() - 1);
										newList.add(tmp);
										newLists.add(newList);
									}
									listMap.put(tmp, newLists);
								}
							}
							else {
	        					// visited before
								if (curLen == prevLen) {
									if (lists != listMap.get(tmp)) {
										for (List<String> list : lists) {
											list.add(tmp);
											listMap.get(tmp).add(list);
										}
									}
								}
								else {
		        					// deep copy
									for (List<String> list : lists) {
										List<String> newList = new LinkedList<String>(list);
										newList.remove(list.size() - 1);
										newList.add(tmp);
										listMap.get(tmp).add(newList);
									}
								}
							}
							visited.put(tmp, level);
						}
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
		return result;
	}

	public static void main(String[] args) {
		String start = "hot";
		String end = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");
		Solution sol = new Solution();
		List<List<String>> result = sol.findLadders(start, end, dict);
		for (List<String> list : result) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}