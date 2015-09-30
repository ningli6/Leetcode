public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
        	if (matrix[i][j] == target) return true;
        	if (matrix[i][j] > target) i -= 1;
        	else j += 1;
        }
        return false;
    }

    public static void main(String[] args) {
    	int[][] matrix = {
    		{1,   4,  7, 11, 15},
    		{2,   5,  8, 12, 19},
    		{3,   6,  9, 16, 22},
    		{10, 13, 14, 17, 24},
    		{18, 21, 23, 26, 30}
    	};
    	Solution sol = new Solution();
    	System.out.println(sol.searchMatrix(matrix, 10));
    }
}