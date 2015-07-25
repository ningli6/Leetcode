public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0; int j = 0;
        int result = nums.length + 1;
        int sum = nums[j];
        while (true) {
        	if (i == j && sum >= s) return 1;
        	if (sum < s) {
        		if (j == nums.length - 1) break;
        		sum += nums[++j];
        	}
        	else {
        		result = Math.min(j - i + 1, result);
        		sum -= nums[i++];
        	}
        }
        return (result == nums.length + 1) ? 0 : result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {2,3,1,2,4,3};
    	System.out.println(sol.minSubArrayLen(7, t));
    }
}