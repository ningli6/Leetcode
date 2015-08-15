/* start from multiple source (chars on the bounds)
 * bfs
 */

import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        Deque<Integer> rindex = new LinkedList();
        Deque<Integer> cindex = new LinkedList();
        for (int j = 0; j < col; j++) {
        	if (board[0][j] == 'O') {
        		rindex.add(0);
        		cindex.add(j);
        	}
        	if (board[row - 1][j] == 'O') {
        		rindex.add(row - 1);
        		cindex.add(j);
        	}
        }
        for (int i = 1; i < row - 1; i++) {
        	if (board[i][0] == 'O') {
        		rindex.add(i);
        		cindex.add(0);
        	}
        	if (board[i][col - 1] == 'O') {
        		rindex.add(i);
        		cindex.add(col - 1);
        	}
        }
        // bfs
        while(!rindex.isEmpty() && !cindex.isEmpty()) {
        	int r = rindex.remove();
        	int c = cindex.remove();
        	board[r][c] = 'Y';
        	if (r > 0 && board[r - 1][c] == 'O') {
        		rindex.add(r - 1);
        		cindex.add(c);
        	}
        	if (r < row - 1 && board[r + 1][c] == 'O') {
        		rindex.add(r + 1);
        		cindex.add(c);
        	}
        	if (c > 0 && board[r][c - 1] == 'O') {
        		rindex.add(r);
        		cindex.add(c - 1);
        	}
        	if (c < col - 1 && board[r][c + 1] == 'O') {
        		rindex.add(r);
        		cindex.add(c + 1);
        	}
        } 
        flip(board);
    }

    private void flip(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j] == 'Y') board[i][j] = 'O';
    			else if (board[i][j] == 'O') board[i][j] = 'X';
    		}
    	}
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	char[][] t = {
    		{'X', '0', 'X', 'X'},
    		// {'X', 'O', 'O', 'X'},
    		// {'X', 'X', 'O', 'X'},
    		// {'X', 'O', 'X', 'X'}
    	};
    	sol.solve(t);
    	for (int i = 0; i < t.length; i++) {
    		for (int j = 0; j < t.length; j++) {
    			System.out.print(t[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}