public class Solution {
    public int majorityElement(int[] nums) {
    	/* Majority Vote Algorithm */
        /* assume that majority element does exist */
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] == result) count++;
        	else if (count == 0) {
        		result = nums[i];
        		count++;
        	}
        	else count--;
        }
        return result;
    }
}