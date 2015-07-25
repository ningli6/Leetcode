import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList();
        Arrays.sort(nums);
        List<Integer> numList = new LinkedList();
        for (int n : nums) numList.add(n);
        return backtrack(numList);
    }

    private List<List<Integer>> backtrack(List<Integer> list) {
    	List<List<Integer>> ret = new LinkedList();
    	if (list.size() == 1) {
    		List<Integer> newList = new LinkedList(list);
    		ret.add(newList);
    		return ret;
    	}
    	for (int i = 0; i < list.size(); i++) {
    		if (i > 0 && list.get(i) == list.get(i - 1)) continue;
    		int tmp = list.remove(i);
    		List<List<Integer>> bt = backtrack(list);
    		for (List<Integer> ls : bt) {
    			ls.add(0, tmp);
    			ret.add(ls);
    		}
    		list.add(i, tmp);
    	}
    	return ret;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2, 1};
    	List<List<Integer>> result = sol.permuteUnique(t);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}