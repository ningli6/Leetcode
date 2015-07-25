public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows + 1; i++) dp[i][cols] = Integer.MAX_VALUE;
        for (int j = 0; j < cols + 1; j++) dp[rows][j] = Integer.MAX_VALUE;
        if (dungeon[rows - 1][cols - 1] >= 0) dp[rows - 1][cols - 1] = 1;
        else dp[rows - 1][cols - 1] = Math.abs(dungeon[rows - 1][cols - 1]) + 1;
        for (int i = rows - 1; i >= 0; i--) {
        	for (int j = cols - 1; j >= 0; j--) {
        		if (i == rows - 1 && j == cols - 1) continue;
        		dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
        		if (dp[i][j] <= 0) dp[i][j] = 1;
        	}
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
    	int[][] dungeon = {
    		{2, 3, 3},
    		// {-5, -10, 1},
    		// {10, 30, -5}
    	};
    	Solution sol = new Solution();
    	System.out.println(sol.calculateMinimumHP(dungeon));
    }
}