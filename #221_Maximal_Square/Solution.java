/* O(m * n) solution */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for (int i = 1; i < rows; i++) {
        	for (int j = 1; j < cols; j++) {
        		if (matrix[i][j] == '0') continue;
        		if (i == 0 || j == 0) dp[i][j] = 1;
        		else {
        			int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
        			int sqrt_min = (int) Math.sqrt(min);
	        		dp[i][j] = (sqrt_min + 1) * (sqrt_min + 1);
	        	}
        		max = Math.max(dp[i][j], max);
        	}
        }
        return max;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	char[][] t = {
    		{'1', '1', '1', '1'},
			{'1', '1', '1', '1'},
			{'1', '1', '1', '1'}
    	};
    	System.out.println(sol.maximalSquare(t));
    }
}