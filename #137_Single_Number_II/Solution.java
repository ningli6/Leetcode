import java.util.BitSet;

/* doesn't work for extremely large integers 
 * use extra space */

public class Solution {
    public int singleNumber(int[] nums) {
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	int len = nums.length;
    	for (int i = 0; i < len; i++) {
    		if (nums[i] < min) min = nums[i];
    		if (nums[i] > max) max = nums[i];
    	}
    	System.out.println(max);
    	System.out.println(min);

    	int bitlen = max - min + 1;
    	System.out.println(bitlen);
    	BitSet bs = new BitSet(2 * bitlen);
    	bs.set(0, 2 * bitlen);
    	for (int i = 0; i < len; i++) {
    		int index = nums[i] - min;
    		if (bs.get(2 * index) && bs.get(2 * index + 1)) {
    			bs.clear(2 * index + 1);
    		}
    		else if (bs.get(2 * index) && !bs.get(2 * index + 1)) {
    			bs.flip(2 * index);
    			bs.flip(2 * index + 1);
    		}
    		else if (!bs.get(2 * index) && bs.get(2 * index + 1)) {
    			bs.clear(2 * index + 1);
    		}
    		else return nums[i];
    	}
    	for (int i = 0; i < bitlen; i++) {
    		if (bs.get(2 * i) && bs.get(2 * i + 1)) continue;
    		if (!bs.get(2 * i) && !bs.get(2 * i + 1)) continue;
    		return i + min;
    	}
    	return nums[0];
    }
    public static void main(String[] args) {
    	int[] test = {-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555};
    	Solution sol = new Solution();
    	System.out.println(sol.singleNumber(test));
    }
}