import java.util.*;

public class Solution2 {
    public int search(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return -1;
    	int lo = 0, hi = nums.length - 1;
    	while (lo < hi) {
    		int mid = (lo + hi) / 2;
    		if (nums[mid] == target) return mid;
    		// left part is sorted
    		if (nums[lo] < nums[mid]) {
    			if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
    			else lo = mid + 1;
    		}
    		// right part is sorted
    		else if (nums[lo] > nums[mid]) {
    			if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
    			else hi = mid - 1;
    		}
    		else { // nums[mid] == nums[lo]
    			lo = mid + 1;
    		}
    	}
    	return -1;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] test = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(sol.search(test, 5));
    }
}