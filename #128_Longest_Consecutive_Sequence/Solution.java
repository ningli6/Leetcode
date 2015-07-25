import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
				int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
				int length = left + right + 1;
				if (length > result) result = length;
				map.put(nums[i], length);
				map.put(nums[i] - left, length);
				map.put(nums[i] + right, length);
			}
		}
		return result;
    }

    public static void main(String[] args) {
    	int[] test = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
    	Solution sol = new Solution();
    	System.out.println(sol.longestConsecutive(test));
    }
}