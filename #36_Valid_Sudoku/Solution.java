import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        BitSet[] rows = new BitSet[9];
        BitSet[] cols = new BitSet[9];
        BitSet[] subs = new BitSet[9];
        for (int i = 0; i < 9; i++) {
        	rows[i] = new BitSet(10);
        }
        for (int i = 0; i < 9; i++) {
        	cols[i] = new BitSet(10);
        }
        for (int i = 0; i < 9; i++) {
        	subs[i] = new BitSet(10);
        }
//      for (BitSet bs : rows) bs = new BitSet(10);
//   	for (BitSet bs : cols) bs = new BitSet(10);
//      for (BitSet bs : subs) bs = new BitSet(10);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') continue;
				int num = board[i][j] - '0';
				if (rows[i].get(num)) return false;
				rows[i].set(num);
				if (cols[j].get(num)) return false;
				cols[j].set(num);
				int k = 3 * (i / 3) + j / 3;
				if (subs[k].get(num)) return false;
				subs[k].set(num);
			}
		}
		return true;
    }

    public static void main(String[] args) {
    	char[][] board = {
    		{'.', '8', '7', '6', '5', '4', '3', '2', '1'},
    		{'2', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'3', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'4', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'5', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'6', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'8', '.', '.', '.', '.', '.', '.', '.', '.'},
    		{'9', '.', '.', '.', '.', '.', '.', '.', '.'}
    	};
    	Solution sol = new Solution();
    	System.out.println(sol.isValidSudoku(board));
    }
}