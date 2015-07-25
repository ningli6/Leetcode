/* greedy approach
 * keep track of the farthest index the array can reach */

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
        	if (i > maxIndex) break;
        	maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return maxIndex >= nums.length - 1;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {2, 3, 1, 1, 4};
    	System.out.println(sol.canJump(t));
    }
}