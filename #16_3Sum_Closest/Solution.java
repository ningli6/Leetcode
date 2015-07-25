import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	/* 避免重复计算 */
        	if (i > 1 && nums[i] == nums[i - 1]) continue;
        	int lo = i + 1;
        	int hi = nums.length - 1;
        	int t = target - nums[i];
        	while (lo < hi) {
	        	if (nums[lo] + nums[hi] == t) return target;
	        	int newDiff = Math.abs(nums[i] + nums[lo] + nums[hi] - target);
	        	if (newDiff < diff) {
	        		diff = newDiff;
	        		result = nums[i] + nums[lo] + nums[hi];
	        	}
	        	if (nums[lo] + nums[hi] > t) hi -= 1;
	        	else lo += 1;
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
    	System.out.println(sol.threeSumClosest(t, -59));
    }
}