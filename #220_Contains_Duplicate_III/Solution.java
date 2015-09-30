import java.util.*;

/**
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array such that 
 * the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k.
 */

/**
 * A binary search tree based solution
 * O(nlog(k));
 */

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k <= 0 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet();
        /* maintain a set of size k + 1 */
        for (int i = 0; i < nums.length; i++) {
        	// System.out.println("Num: " + nums[i]);
        	/* find the least value that is greater than or equal to */
        	Integer ceiling = set.ceiling(nums[i] - t);
        	/* find the greatest value that is less than or equal to */
        	Integer floor = set.floor(nums[i] + t);
        	if (ceiling != null && ceiling <= nums[i]) {
        		// System.out.println("Ceiling: " + ceiling + ", num: " + nums[i]);
        		return true;
        	}
        	if (floor != null && floor >= nums[i]) {
        		// System.out.println("Floor: " + floor + ", num: " + nums[i]);
        		return true;
        	}
        	if (!set.add(nums[i])) return false;
        	if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] t = {1, 1, 1};
    	Solution sol = new Solution();
    	System.out.println(sol.containsNearbyAlmostDuplicate(t, 2, 1));
    }
}