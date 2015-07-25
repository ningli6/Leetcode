import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        if (nums == null || nums.length == 0) return subsets;
        subsets.add(new LinkedList());
        Arrays.sort(nums);
        for (int t : nums) {
        	int size = subsets.size();
        	for (int i = 0; i < size; i++) {
        		List<Integer> newList = new LinkedList(subsets.get(i));
        		newList.add(t);
        		subsets.add(newList);
        	}
        }
        return subsets;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2, 3};
    	sol.subsets(t);
    }
}