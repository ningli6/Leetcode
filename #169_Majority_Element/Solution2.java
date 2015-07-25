/* bit manipulation */

public class Solution2 {
    public int majorityElement(int[] nums) {
    	int result = 0;
    	for (int i = 0; i < 32; i++) {
    		int count1 = 0, count0 = 0;
    		for (int j = 0; j < nums.length; j++) {
    			if ((nums[j] & (1 << i)) == 0) count0++; // corner case for -2^31
    			else count1++;
    		}
    		if (count1 > count0) result |= (1 << i);
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] t = {-2147483648};
    	System.out.println(sol.majorityElement(t));
    }
}