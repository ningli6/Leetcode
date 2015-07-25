public class Solution {
	static int left, right;
    public static int[] searchRange(int[] nums, int target) {
    	/* find left bound */
    	left = -1; right = -1;
    	searchLeft(nums, target, 0, nums.length - 1);
    	searchRight(nums, target, 0, nums.length - 1);
    	// System.out.println("Left: " + left + ", Right: " + right);
    	if (left == right) {
    		if (left < 0 || left >= nums.length) return new int[]{-1, -1};
    		if (nums[left] != target) return new int[]{-1, -1};
    	}
    	if (left > right) return new int[]{-1, -1};
        int[] res = new int[2];
        res[0] = left; res[1] = right;
        return res;
    }

    private static void searchLeft(int[] nums, int target, int lo, int hi) {
    	if (lo > hi) return;
    	int mid = (lo + hi) / 2;
    	if (nums[mid] > target) {
    		left = mid - 1;
    		searchLeft(nums, target, lo, left);
    	}
    	else if (nums[mid] < target) {
    		left = mid + 1;
    		searchLeft(nums, target, left, hi);
    	}
    	else {
    		left = mid;
    		searchLeft(nums, target, lo, left - 1);
    	}
    }

    private static void searchRight(int[] nums, int target, int lo, int hi) {
    	if (lo > hi) return;
    	int mid = (lo + hi) / 2;
    	if (nums[mid] > target) {
    		right = mid - 1;
    		searchRight(nums, target, lo, right);
    	}
    	else if (nums[mid] < target) {
    		right = mid + 1;
    		searchRight(nums, target, right, hi);
    	}
    	else {
    		right = mid;
    		searchRight(nums, target, right + 1, hi);
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] s = {2, 2};
    	int[] res = sol.searchRange(s, 3);
    	System.out.println(res[0] + ", " + res[1]);
    }
}