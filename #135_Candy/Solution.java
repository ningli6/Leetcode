public class Solution {
    public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) return 0;
		int[] candy = new int[ratings.length];
		for (int i = 0; i < candy.length; i++) candy[i] = 1;
		/* iter thru left to right */
		for (int i = 1; i < candy.length; i++) {
			if (ratings[i - 1] < ratings[i]) candy[i] = candy[i - 1] + 1;
		}
		/* iter thru right to left */
		for (int i = candy.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
		}
		int sum = 0;
		for (int i = 0; i < candy.length; i++) sum += candy[i];
		return sum;
    }

    public static void main(String[] args) {
    	int[] t = {1, 2, 3, 1};
    	Solution sol = new Solution();
    	System.out.println(sol.candy(t));
    }
}