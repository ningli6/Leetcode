import java.util.*;

/**
 * Boyer-Moore Majority Vote algorithm
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> re = new LinkedList();
        if (nums == null || nums.length == 0) return re;
        int count0 = 0;
        int count1 = 0;
        int num0 = 0;
        int num1 = 1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == num0) count0++;
        	else if (nums[i] == num1) count1++;
        	else if (count0 == 0) {
        		num0 = nums[i];
        		count0 = 1;
        	}
        	else if (count1 == 0) {
        		num1 = nums[i];
        		count1 = 1;
        	}
        	else {
        		count1--;
        		count0--;
        	}
        }
        if (count0 > 0 && count(nums, num0) > nums.length / 3) re.add(num0);
        if (count1 > 0 && count(nums, num1) > nums.length / 3) re.add(num1);
        return re;
    }

    private int count(int[] nums, int n) {
    	int count = 0;
    	for (int it : nums) {
    		if (it == n) count++;
    	}
    	return count;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {3, 2, 1, 4, 1};
    	List<Integer> re = sol.majorityElement(t);
    	for (int it : re) {
    		System.out.println(it);
    	}
    }
}