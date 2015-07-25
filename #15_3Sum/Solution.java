/* A O(n^2) solution */

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	/* skip duplicates */
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	int target = 0 - nums[i];
        	int lo = i + 1;
        	int hi = nums.length - 1;
        	while (lo < hi) {
        		if (nums[lo] + nums[hi] == target) {
        			List<Integer> newList = new LinkedList<Integer>();
        			newList.add(nums[i]);
					newList.add(nums[lo]);
					newList.add(nums[hi]);
					result.add(newList);
					/* skip duplicates */
					while (lo + 1 < nums.length && nums[lo + 1] == nums[lo]) lo++;
					while (hi - 1 > i && nums[hi - 1] == nums[hi]) hi--;
					hi -= 1; lo += 1;
        		}
        		else if (nums[lo] + nums[hi] > target) hi -= 1;
        		else lo += 1;
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {-1, 0, 1, 2, -1, -4};
    	List<List<Integer>> result = sol.threeSum(t);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}