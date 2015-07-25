import java.util.*;

/* Quick selection O(n) on average */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	if (nums == null || nums.length < k || k <= 0) return -1;
        shuffle(nums);
        int j = -1;
        int lo = 0; int hi = nums.length - 1;
        while (j != nums.length - k) {
        	j = partition(nums, lo, hi);
        	if (j < nums.length - k) lo = j + 1;
        	if (j > nums.length - k) hi = j - 1;
        }
        return nums[j];
    }

    private static int partition(int[] nums, int lo, int hi) {
    	if (lo == hi) return lo;
    	int i = lo;
    	int j = hi + 1;
    	while (true) {
    		while (nums[++i] < nums[lo]) {
    			if (i == hi) break;
    		}
    		while (nums[--j] > nums[lo]) {
    			if (j == lo) break;
    		}
    		if (i >= j) break;
    		int tmp = nums[j];
    		nums[j] = nums[i];
    		nums[i] = tmp;
    	}
    	int tmp = nums[lo];
    	nums[lo] = nums[j];
    	nums[j] = tmp;
    	return j;
    }

    // knuth shuffle
    private static void shuffle(int[] nums) {
    	if (nums == null || nums.length < 2) return;
    	int len = nums.length;
    	Random random = new Random();
    	for (int i = len - 1; i >= 0; i--) {
    		// j ← random integer such that 0 ≤ j ≤ i
    		/**
    		 * nextInt(int bound)
    		 * Returns a pseudorandom, 
    		 * uniformly distributed int value between 0 (inclusive) and the specified value (exclusive), 
    		 * drawn from this random number generator's sequence.
    		 */
    		int j = random.nextInt(i + 1);
    		// exchange a[j] and a[i]
    		int tmp = nums[j];
    		nums[j] = nums[i];
    		nums[i] = tmp;
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2, 3, 4, 5};
    	System.out.println(sol.findKthLargest(t, 4));
    }
}