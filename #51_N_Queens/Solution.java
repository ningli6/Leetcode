import java.util.List;
import java.util.LinkedList;

public class Solution {
	public List<String[]> solveNQueens(int n) {
		if (n < 0) throw new IllegalArgumentException();
		LinkedList<String[]> reltlist = new LinkedList<String[]>();
		if (n == 1) {
			String[] results = {"Q"};
			reltlist.add(results);
			return reltlist;
		}
		if (n == 0 || n == 2 || n == 3) return reltlist;
		boolean[][] board = new boolean[n][n];
		backTrace(reltlist, board, 0, 0, n);
		return reltlist;
	}

	private void backTrace(List<String[]> reltlist, boolean[][] board, int row, int col, int N) {
		if (row == 0) {
			for (int c = 0; c < N; c++) {
				board[row][c] = true;
				if (!isValid(board)) {
					board[row][c] = false;
					continue;
				}
				if (row == N - 1) {
					/* debug */
					// System.out.println("N Queens!");
					// printBoard(board);
					addBoard(reltlist, board);
					board[row][c] = false;
					return;
				}
				else backTrace(reltlist, board, row + 1, c, N);
				board[row][c] = false;
			}
		}
		else {
			for (int c = 0; c < N; c++) {
				if (!(c < col - 1 || c > col + 1)) continue;
				board[row][c] = true;
				if (!isValid(board)) {
					board[row][c] = false;
					continue;
				}
				if (row == N - 1) {
					/* debug */
					// System.out.println("N Queens!");
					// printBoard(board);
					addBoard(reltlist, board);
					board[row][c] = false;
					return;
				}
				else backTrace(reltlist, board, row + 1, c, N);
				board[row][c] = false;
			}
		}
	}

	private boolean isValid(boolean[][] board) {
		/* debug */
		// printBoard(board);
		int N = board.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]) {
					if (!checkRow(board, i)) return false;
					if (!checkCol(board, j)) return false;
					if (!checkDiag(board, i, j)) return false;
				}
			}
		}
		/* debug */
		// System.out.println("T");
		return true;
	}

	private void addBoard(List<String[]> reltlist, boolean[][] board) {
		int N = board.length;
		String[] b = new String[N];
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				if (board[i][j]) sb.append("Q");
				else sb.append(".");
			}
			b[i] = sb.toString();
		}
		reltlist.add(b);
	}

	private boolean checkRow(boolean[][] board, int row) {
		int N = board.length;
		int count = 0;
		for (int c = 0; c < N; c++) {
			if (board[row][c]) count++;
		}
		return (count > 1) ? false : true;
	}

	private boolean checkCol(boolean[][] board, int col) {
		int N = board.length;
		int count = 0;
		for (int r = 0; r < N; r++) {
			if (board[r][col]) count++;
		}
		return (count > 1) ? false : true;
	}

	private boolean checkDiag(boolean[][] board, int row, int col) {
		int N = board.length;
		int count = 0;
		int r = row - 1;
		int c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r--][c--]) count++;
		}
		r = row + 1;
		c = col + 1;
		while (r < N && c < N) {
			if (board[r++][c++]) count++;
		}
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < N) {
			if (board[r--][c++]) count++;
		}
		r = row + 1;
		c = col - 1;
		while (r < N && c >= 0) {
			if (board[r++][c--]) count++;
		}
		return (count > 0) ? false : true;
	}

	/* debug */
	private void printBoard(boolean[][] board) {
		System.out.println("****************");
		int N = board.length;
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				if (board[i][j]) sb.append("Q");
				else sb.append(".");
			}
			System.out.println(sb.toString());
		}
		System.out.println("****************");
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String[]> results = sol.solveNQueens(4);
		for (String[] sa : results) {
			for (String s : sa) {
				System.out.println(s);
			}
			System.out.println();
		}
	}

}