import java.util.*;

public class Solution {
    public boolean search(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return false;
    	int lo = 0, hi = nums.length - 1;
    	while (lo < hi) {
    		int mid = (lo + hi) / 2;
    		if (nums[mid] == target) return true;
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
    			lo++;
    		}
    	}
    	return false;
    }
}