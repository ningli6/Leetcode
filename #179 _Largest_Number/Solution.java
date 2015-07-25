import java.util.*;

public class Solution {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strNums[i] = Integer.toString(nums[i]);
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strNums, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		return -(a + b).compareTo(b + a);
        	}
        });
        for (int i = 0; i < strNums.length; i++) {
        	sb.append(strNums[i]);
        }
        /* delete leading 0's */
        while (sb.charAt(0) == '0' && sb.length() > 1) {
        	sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {0, 0};
    	System.out.println(sol.largestNumber(t));
    }
}