/* O(n) add, O(1) find, O(n) space */

import java.util.*;

public class TwoSum {
	Map<Integer, Integer> map;

	public TwoSum() {
		map = new HashMap<Integer, Integer>();
	}

	public void add(int number) {
		if (!map.containsKey(number)) map.put(number, 1);
		else map.put(number, 2);
	}

	public boolean find(int value) {
		for (Integer key : map.keySet()) {
			if ((value - key != key && map.containsKey(value - key)) || (value - key == key && map.get(key) > 1))
				return true;
		}
		System.out.println("return");
		return false;
	}

	public static void main(String[] args) {
		TwoSum sol = new TwoSum();
		sol.add(0);
		sol.add(0);
		System.out.println(sol.find(0));
	}
}