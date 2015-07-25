/* one pass solution */

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        int rindex = 0; int bindex = len - 1;
        int i = 0;
        while (i <= bindex) {
        	if (nums[i] == 0) {
        		swap(nums, i++, rindex++);
        	}
        	else if (nums[i] == 2) {
        		swap(nums, i, bindex--);
        	}
        	else i++;
        }
    }

    private static void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2, 0, 1, 2, 0};
    	sol.sortColors(t);
    	for (int g : t) {
    		System.out.print(g + " ");
    	}
    	System.out.println();
    }
}