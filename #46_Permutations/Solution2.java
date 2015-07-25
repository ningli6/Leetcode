/* Backtracing solution */
import java.util.*;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if (nums == null || nums.length == 0) return result;
    	Set<Integer> set = new HashSet();
    	for (int n : nums) set.add(n);
    	return bt(set);
    }

    private List<List<Integer>> bt(Set<Integer> set) {
    	List<List<Integer>> res = new LinkedList();
    	if (set.size() == 1) {
    		List<Integer> newList = new LinkedList();
    		for (Integer it : set) newList.add(it);
    		res.add(newList);
    		return res;
    	}
    	for (Integer tmp : set) {
    		set.remove(tmp);
    		List<List<Integer>> newList = bt(set);
    		for (List<Integer> ls : newList) {
    			ls.add(0, tmp);
    			res.add(ls);
    		}
    		set.add(tmp);
    	}
    	return res;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] t = {1, 2, 3};
    	List<List<Integer>> result = sol.permute(t);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}