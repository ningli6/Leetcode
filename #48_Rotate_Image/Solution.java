public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) return;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
        	for (int j = i; j < n - i - 1; j++) {
        		// (i, j) -> (j, n - i - 1)
        		int tmp = matrix[j][n - i - 1];
        		matrix[j][n - i - 1] = matrix[i][j];
        		// (j, n - i - 1) -> (n - i - 1, n - j - 1)
        		int tmp2 = matrix[n - i - 1][n - j - 1];
        		matrix[n - i - 1][n - j - 1] = tmp;
        		tmp = tmp2;
        		// (n - i - 1, n - j - 1) -> (n - j - 1, i)
        		tmp2 = matrix[n - j - 1][i];
        		matrix[n - j - 1][i] = tmp;
        		tmp = tmp2;
        		// (n - j - 1, i) -> (i, j)
        		matrix[i][j] = tmp;
        	}
        }
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[][] matrix = {
    		{1, 2, 3, 4},
    		{5, 6, 7, 8},
    		{9, 10, 11, 12},
    		{13, 14, 15, 16}
    	};
    	sol.rotate(matrix);
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix.length; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}