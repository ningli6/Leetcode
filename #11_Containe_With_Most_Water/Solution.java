public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int max = 0;
        int i = 0; int j = height.length - 1;
        while (i < j) {
        	max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
        	if (height[i] < height[j]) i++;
        	else j--;
        }
        return max;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = new int[5];
    }
}