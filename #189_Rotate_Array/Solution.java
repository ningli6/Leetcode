public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
    	k %= nums.length;
    	if (k == 0) return;
    	reverse(nums, 0, nums.length - 1);
    	reverse(nums, 0, k - 1);
    	reverse(nums, k, nums.length - 1);
    }

    /* reverse array from i to j inclusively */
    private void reverse(int[] nums, int i, int j) {
    	if (nums == null || nums.length == 0) return;
    	if (i == j) return;
    	if (i > j || i < 0 || j >= nums.length) return;
    	while (i <= j) {
    		int tmp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = tmp;
    		i++;
    		j--;
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2, 3, 4, 5, 6, 7};
    	sol.rotate(t, 3);
    	for (Integer it : t) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}