import java.util.*;

/* Solve the problem in a recursive way
 * It's easier to remove duplicates this way
 */

public class Recursive {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new LinkedList();
		if (nums == null || nums.length == 0) return subsets;
		List ept = new LinkedList();
		subsets.add(ept);
        Arrays.sort(nums);
        findSubs(subsets, ept, nums, 0);
        return subsets;
	}

	private void findSubs(List<List<Integer>> subsets, List<Integer> list, int[] nums, int start) {
		for (int i = start; i < nums.length; i++) {
			List<Integer> newList = new LinkedList(list);
			newList.add(nums[i]);
			subsets.add(newList);
			findSubs(subsets, newList, nums, i + 1);
		}
	}

	public static void main(String[] args) {
    	Recursive sol = new Recursive();
    	int[] t = {1, 2, 3};
    	List<List<Integer>> result = sol.subsets(t);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}