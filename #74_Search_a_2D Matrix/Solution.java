public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null) return false;
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	int min = matrix[0][0];
    	int max = matrix[rows - 1][cols - 1];
    	if (target < min || target > max) return false;
    	/* binary search for rows which target belongs to */
    	int lo = 0; int hi = rows - 1; int mid = (lo + hi) / 2;
    	int row = -1;
    	while (true) {
    		if (matrix[mid][0] <= target && matrix[mid][cols - 1] >= target) {
    			row = mid; break;
    		}
    		if (matrix[mid][0] > target) {
    			hi = mid - 1;
    			if (lo > hi || lo >= rows || hi < 0) return false;
    			mid = (lo + hi) / 2;
    		}
    		if (matrix[mid][cols - 1] < target) {
    			lo = mid + 1;
    			if (lo > hi || lo >= rows || hi < 0) return false;
    			mid = (lo + hi) / 2;
    		}
    	}
    	/* binary search for specific row */
    	lo = 0; hi = cols - 1; mid = (lo + hi) / 2;
    	while(true) {
    		if (matrix[row][mid] == target) return true;
    		if (matrix[row][mid] < target) {
    			lo = mid + 1;
    			if (hi < 0 || lo > hi || lo >= cols) return false;
    			mid = (lo + hi) / 2;
    		}
    		if (matrix[row][mid] > target) {
    			hi = mid - 1;
    			if (hi < 0 || lo > hi || lo >= cols) return false;
    			mid = (lo + hi) / 2;
    		}
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[][] test = {
    		{1},
    		{3}
    	};
    	System.out.println(sol.searchMatrix(test, 3));
    }
}