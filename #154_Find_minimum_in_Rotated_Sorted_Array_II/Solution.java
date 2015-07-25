public class Solution {
    public int findMin(int[] nums) {
    	int len = nums.length;
    	int lo = 0, hi = len - 1;
    	while (true) {
    		/* inorder */
    		if (nums[lo] < nums[hi]) return nums[lo];
    		if (lo == hi) return nums[lo];
    		if (lo == hi - 1) return Math.min(nums[lo], nums[hi]);
    		int mid = (lo + hi) / 2;
			if (nums[lo] < nums[mid]) lo = mid + 1; // search right
    		else if (nums[lo] > nums[mid]) hi = mid; // search left
    		else lo++; // worst case O(n)
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {10,1,10,10,10};
    	System.out.println(sol.findMin(t));
    }
}