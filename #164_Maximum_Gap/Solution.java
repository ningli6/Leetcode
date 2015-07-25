/* Bucket sort */

import java.util.*;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        /* find min & max */
        for (int i = 0; i < nums.length; i++) {
        	min = Math.min(min, nums[i]);
        	max = Math.max(max, nums[i]);
        }
        /* bucket length */
        int blen = (max - min) / (nums.length - 1);
        if (blen == 0) blen += 1; // corner case
        // System.out.println("blen: " + blen);
        /* number of buckets */
        int n = (max - min) / blen + 1;
        // System.out.println("n: " + n);
        /* initial min & max for each buckets */
        int[][] buckets = new int[n][2];
        for (int i = 0; i < n; i++) {
        	buckets[i][0] = -1;
        	buckets[i][1] = -1;
        }
        /* divide nums into buckets */
        for (int i = 0; i < nums.length; i++) {
        	int index = (nums[i] - min)/ blen;
        	if (buckets[index][0] == -1) {
        		buckets[index][0] = nums[i];
        		buckets[index][1] = nums[i];
        	}
        	else {
        		buckets[index][0] = Math.min(buckets[index][0], nums[i]);
        		buckets[index][1] = Math.max(buckets[index][1], nums[i]);
        	}
        }
        /* find the max gap */
        int result = 0;
        int prevIndex = 0;
        for (int i = 1; i < n; i++) { // need to skip empty bucket
        	if (buckets[i][0] == -1) continue; 
        	result = Math.max(result, buckets[i][0] - buckets[prevIndex][1]);
        	prevIndex = i;
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 1, 1, 1, 1, 5, 5, 5, 5, 5};
    	System.out.println(sol.maximumGap(t));
    }
}