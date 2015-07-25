import java.util.*;

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
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
			if (i != start && nums[i] == nums[i - 1]) continue;
			List<Integer> newList = new LinkedList(list);
			newList.add(nums[i]);
			subsets.add(newList);
			findSubs(subsets, newList, nums, i + 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] t = {1, 1};
    	List<List<Integer>> result = sol.subsetsWithDup(t);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
	}
}