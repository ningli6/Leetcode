import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList();
        if (k == 0 || k > n || 9 * k < n) return result;
        return combinationSum3(1, k, n);
    }

    private List<List<Integer>> combinationSum3(int lo, int level, int sum) {
    	List<List<Integer>> result = new LinkedList();
    	if (level <= 0 || sum <= 0 || 9 * level < sum || lo > 9) return result;
    	for (int i = lo; i < 10; i++) {
    		if (level == 1 && i == sum) {
    			List bottom = new LinkedList();
    			bottom.add(i);
    			result.add(bottom);
    			return result;
    		} 
    		List<List<Integer>> list = combinationSum3(i + 1, level - 1, sum - i);
    		for (List<Integer> ls : list) {
    			ls.add(0, i);
    			result.add(ls);
    		}
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> result = sol.combinationSum3(3, 9);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}