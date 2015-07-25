public class Solution {
    public int removeElement(int[] nums, int val) {
    	if (nums == null || nums.length == 0) return 0;
    	int len = nums.length;
    	int count = 0;
    	int i = 0, j = len - 1;
    	while (i <= j) {
    		if (nums[i] == val) {
    			if (nums[j] == val) {
    				j--; count++;
    				continue;
    			}
    			nums[i] = nums[j];
    			nums[j] = val;
    			j--; count++;
    		}
    		i++;
    	}
    	return len - count;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2, 2, 3};
    	System.out.println(sol.removeElement(t, 2));
    	for (int it : t) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}