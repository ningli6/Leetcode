import java.util.*;

public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new LinkedList();
		if (upper < lower) return result;
		if (nums == null || nums.length == 0) {
			if (lower == upper) result.add(Integer.toString(lower));
			else result.add(Integer.toString(lower) + "->" + Integer.toString(upper));
			return result;
		}
		/* handle the first gap */
		if (lower < nums[0]) {
			int lo = lower; 
			int hi = nums[0] - 1;
			if (lo == hi) result.add(Integer.toString(lo));
			else result.add(Integer.toString(lo) + "->" + Integer.toString(hi));
		}
		/* handle the middle elements */
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > 1) {
				int lo = nums[i - 1] + 1;
				int hi = nums[i] - 1;
				if (lo == hi) result.add(Integer.toString(lo));
				else result.add(Integer.toString(lo) + "->" + Integer.toString(hi));
			}
		}
		/* handle the last gap */
		if (upper > nums[nums.length - 1]) {
			int lo = nums[nums.length - 1] + 1; 
			int hi = upper;
			if (lo == hi) result.add(Integer.toString(lo));
			else result.add(Integer.toString(lo) + "->" + Integer.toString(hi));
		}
		return result;
	}
}