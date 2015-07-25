public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int rows = obstacleGrid.length; int cols = obstacleGrid[0].length;
        if (rows < 1 || cols < 1) return 0;
    	int[] dp = new int[cols];
        if (obstacleGrid[0][0] > 0) return 0;
        dp[0] = 1;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] > 0) {
                    dp[j] = 0;
                }
                else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
    		}
    	}
    	return dp[cols - 1];
    }

    public static void main(String[] args) {
        int[][] t = new int[4][0];
        System.out.println(t.length + ", " + t[0].length);
    }
}