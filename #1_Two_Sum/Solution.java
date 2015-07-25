/* A hash table based O(n) solution */

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(target - nums[i])) {
        		result[0] = map.get(target - nums[i]) + 1;
        		result[1] = i + 1;
        		break;
        	}
        	map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
    	int[] t = {2, 7, 11, 15};
    	int target = 9;
    	Solution sol = new Solution();
    	int[] res = sol.twoSum(t, target);
    	System.out.println(res[0] + ", " + res[1]);
    }
}