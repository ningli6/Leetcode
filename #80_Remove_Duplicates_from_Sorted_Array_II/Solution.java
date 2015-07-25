public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cp = 1, cur = 1, count = 0;
        while (cur < nums.length) {
        	if (nums[cur] == nums[cur - 1]) count++;
        	else count = 0;
        	if (count < 2) {
        		nums[cp++] = nums[cur];
        	}
        	cur++;
        }
        return cp;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 1, 1, 1, 1, 1};
    	System.out.println(sol.removeDuplicates(t));
    }
}