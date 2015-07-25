public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
    	if (n == 0) return result;
        if (n == 1) {
        	result[0][0] = 1;
        	return result;
        }
        int max = n * n;
        int index = 1;
        int level = n;
    	int startRow = 0; int startCol = 0;
        while (index <= max) {
        	int i = startRow; int j = startCol;
        	while (j < level) {
        		result[i][j] = index++;
        		j++;
        	}
        	i++; j--;
        	while (i < level) {
        		result[i][j] = index++;
        		i++;
        	}
        	i--; j--;
        	while (j >= startCol) {
        		result[i][j] = index++;
        		j--;
        	}
        	j++; i--;
        	while (i > startRow) {
        		result[i][j] = index++;
        		i--;
        	}
        	startRow++; startCol++; level -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[][] result = sol.generateMatrix(0);
    	for (int i = 0; i < result.length; i++) {
    		for (int j = 0; j < result[0].length; j++) {
    			System.out.print(result[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}