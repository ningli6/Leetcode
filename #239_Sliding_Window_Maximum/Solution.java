import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<Integer>();
        int[] re = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (!queue.isEmpty() && queue.getFirst() <= i - k) {
        		queue.pollFirst();
        	}
        	while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[i]) {
        		queue.pollFirst();
        	}
        	queue.offerLast(i);
        	if (i >= k - 1) {
	        	re[index++] = nums[queue.getFirst()];
        	}
        }
        return re;
    }

    public static void main(String[] args) {
    	int[] nums = {1,3,-1,-3,5,3,6,7};
    	Solution sol = new Solution();
    	int[] re = sol.maxSlidingWindow(nums, 3);
    	for (int i : re) {
    		System.out.println(i);
    	}
    }
}