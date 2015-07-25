import java.util.*;

public class Solution {

	int rows;
	int cols;

    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] isMarked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (grid[i][j] == '1' && !isMarked[i][j]) {
        			result++;
        			explore(grid, isMarked, i, j);
        		}
        	}
        }
        return result;
    }

    public void explore(char[][] grid, boolean[][] isMarked, int i, int j) {
    	isMarked[i][j] = true;
    	if (i - 1 >= 0 && grid[i - 1][j] == '1' && !isMarked[i - 1][j])
    		explore(grid, isMarked, i - 1, j);
    	if (j - 1 >= 0 && grid[i][j - 1] == '1' && !isMarked[i][j - 1])
    		explore(grid, isMarked, i, j - 1);
    	if (i + 1 < rows && grid[i + 1][j] == '1' && !isMarked[i + 1][j])
    		explore(grid, isMarked, i + 1, j);
    	if (j + 1 < cols && grid[i][j + 1] == '1' && !isMarked[i][j + 1])
    		explore(grid, isMarked, i, j + 1);
    }

    public static void main(String[] args) {
    	char[][] grid = {
    		{'1', '1', '0', '0', '0'},
    		{'1', '1', '0', '0', '0'},
    		{'0', '0', '1', '0', '0'},
    		{'0', '0', '0', '1', '1'}
    	};
    	Solution sol = new Solution();
    	System.out.println(sol.numIslands(grid));
    }
}