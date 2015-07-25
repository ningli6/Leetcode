import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0) return false;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
        	if (!map.containsKey(nums[i])) {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(nums[i], list);
        	}
        	else {
        		map.get(nums[i]).add(i);
        	}
        }
        for (List<Integer> ls : map.values()) {
        	if (ls.size() < 2) continue;
        	for (int i = 1; i < ls.size(); i++) {
        		if (ls.get(i) - ls.get(i - 1) <= k) return true;
        	}
        }
        return false;
    }
}