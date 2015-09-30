import java.util.*;

public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        if (k <= 0 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i] + t);
            Integer ceil = set.ceiling(nums[i] - t);
            if (floor != null && floor >= nums[i]) return true;
            if (ceil != null && ceil <= nums[i]) return true;
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, Integer.MAX_VALUE};
        System.out.println(sol.containsNearbyAlmostDuplicate(nums, 2, 1));
    }
}