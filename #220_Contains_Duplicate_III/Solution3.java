import java.util.*;

public class Solution3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucket = nums[i] / (t + 1);
            if ((map.containsKey(bucket) && Math.abs(map.get(bucket) - nums[i]) <= t)
                || (map.containsKey(bucket - 1) && nums[i] - map.get(bucket - 1) <= t)
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - nums[i] <= t))
                return true;
            if (i >= k) {
                map.remove(nums[i - k] / (t + 1));
            }
            map.put(bucket, nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int[] nums = {-1, 2147483647};
        System.out.println(sol.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}