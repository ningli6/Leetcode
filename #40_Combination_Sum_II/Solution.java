import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList();
        if (candidates == null || candidates.length == 0) return result;
        List<Integer> list = new LinkedList();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, 0, result, list);
        return result;
    }

    private void backtrace(int[] candidates, int target, int start, int sum, List<List<Integer>> result, List<Integer> list) {
    	for (int i = start; i < candidates.length; i++) {
    		/* debug */
    		// System.out.println("###");
    		// for (Integer it : list) {
    		// 	System.out.print(it + " ");
    		// }
    		// System.out.println();
    		// System.out.println("try " + candidates[i]);
    		sum += candidates[i];
    		if (sum > target) return;
    		list.add(candidates[i]);
    		if (sum == target) {
    			List<Integer> newList = new LinkedList(list);
    			// System.out.println("add!");
    			result.add(newList);
    		}
    		/* sum < target */
    		backtrace(candidates, target, i + 1, sum, result, list);
    		sum -= candidates[i];
    		/* remove(int index) */
    		list.remove(list.size() - 1);
    		while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {10,1,2,7,6,1,5};
    	int target = 8;
    	List<List<Integer>> result = sol.combinationSum2(t, target);
    	for (List<Integer> list : result) {
    		for (Integer it : list) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}