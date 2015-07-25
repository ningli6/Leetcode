/* 3 times traversal */

public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 1) return 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1; i < len; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        for (int i = len - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        int sum = 0;
	    for (int i = 0; i < len; i++) {
	    	sum += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
	    }
	    return sum;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] s = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(sol.trap(s));
    }
}