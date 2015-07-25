import java.util.BitSet;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        BitSet bsr = new BitSet(rows);
        BitSet bsc = new BitSet(cols);
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (matrix[i][j] == 0) {
					bsr.set(i); bsc.set(j);
        		}
        	}
        }
        for (int i = 0; i < rows; i++) {
        	if (bsr.get(i)) {
        		for (int c = 0; c < cols; c++) matrix[i][c] = 0;
        	}
        }
        for (int j = 0; j < cols; j++) {
        	if (bsc.get(j)) {
        		for (int r = 0; r < rows; r++) matrix[r][j] = 0;
        	}
        }
    }

    public static void main(String[] args) {
    	
    }
}