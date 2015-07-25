/* A two pointer based O(n) Solution2 */

import java.util.*;

class Num {
    int val;
    int index;
    Num(int v, int i) {val = v; index = i;}
}

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
        Num[] numArray = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArray[i] = new Num(nums[i], i);
        }
        Arrays.sort(numArray, new Comparator<Num>() {
            @Override
            public int compare(Num n1, Num n2) {
                return n1.val - n2.val;
            }
        });
        int lo = 0; int hi = nums.length - 1;
        while (lo < hi) {
            if (numArray[lo].val + numArray[hi].val == target) {
                result[0] = numArray[lo].index + 1;
                result[1] = numArray[hi].index + 1;
                if (result[0] > result[1]) {
                    int tmp = result[0];
                    result[0] = result[1];
                    result[1] = tmp;
                }
                break;
            }
            else if (numArray[lo].val + numArray[hi].val > target) hi -= 1;
            else lo += 1;
        }
        return result;
    }

    public static void main(String[] args) {
    	int[] t = {-1,-2,-3,-4,-5};
    	int target = -8;
    	Solution2 sol = new Solution2();
    	int[] res = sol.twoSum(t, target);
    	System.out.println(res[0] + ", " + res[1]);
    }
}