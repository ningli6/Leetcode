public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        /* fill in left */
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	left[i] = Math.max(left[i - 1], prices[i] - min);
        	if (prices[i] < min) min = prices[i];
        }
        /* fill in right */
        int max = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
        	right[i] = Math.max(right[i + 1], max - prices[i]);
        	if (prices[i] > max) max = prices[i];
        }
        /* combine both */
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
        	if (i == 0) result = right[i];
        	else result = Math.max(result, left[i] + right[i + 1]);
        }
        result = Math.max(result, left[0]);
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] test = {1, 4, 5, 7, 6, 3, 2, 9};
    	System.out.println(sol.maxProfit(test));
    }
}