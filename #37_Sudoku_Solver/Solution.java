import java.util.*;

/* mind rows/cols or i/j, error prone!
 * mind that elements are frome 1 to 9, while bitset indices are from 0 to 8 */

public class Solution {
	BitSet[] rows;
	BitSet[] cols;
	BitSet[] subs;
    public void solveSudoku(char[][] board) {
    	if (board == null || board.length != 9 || board[0].length != 9) return;
        rows = new BitSet[9];
        cols = new BitSet[9];
        subs = new BitSet[9];
        for (int i = 0; i < 9; i++) {
        	rows[i] = new BitSet(9);
        	cols[i] = new BitSet(9);
        	subs[i] = new BitSet(9);
        }
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			int num = board[i][j] - '1';
        			rows[i].set(num);
        			cols[j].set(num);
        			subs[3 * (i / 3) + j / 3].set(num);
        		}
        	}
        }
        bt(board, 0, 0);
    }

    private boolean bt(char[][] board, int r, int c) {
    	if (r == 9) {
    		return true;
    	}
    	if (board[r][c] != '.') {
    		if (c == 8) return bt(board, r + 1, 0);
    		return bt(board, r, c + 1);
    	}
    	else {
    		for (int i = 1; i < 10; i++) {
    			//!important: minus 1
    			if (isValid(i - 1, r, c)) {
    				rows[r].set(i - 1);
    				cols[c].set(i - 1);
    				subs[3 * (r / 3) + c / 3].set(i - 1);
    				board[r][c] = (char) (i + '0');
    				boolean res;
    				if (c == 8) res = bt(board, r + 1, 0);
    				else res = bt(board, r, c + 1);
    				if (res) return true;
    				board[r][c] = '.';
    				rows[r].clear(i - 1);
    				cols[c].clear(i - 1);
    				subs[3 * (r / 3) + c / 3].clear(i - 1);
    			}
    		}
    		return false;
    	}
    }

    private boolean isValid(int num, int i, int j) {
    	return (!rows[i].get(num) && !cols[j].get(num) && !subs[3 * (i / 3) + j / 3].get(num));
    }

    public static void main(String[] args) {
    	char[][] test = {
    		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
    		{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
    		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
    		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
    		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
    		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
    		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
    		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
    		{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    	};
    	Solution sol = new Solution();
    	sol.solveSudoku(test);
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(test[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}