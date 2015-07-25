import java.util.*;

public class Solution {
	int result; // final result
	int len;    // length of board
	boolean[] cols;
	boolean[] diag0;
	boolean[] diag1;
	public int totalNQueens(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		result = 0;
		len = n;
		cols = new boolean[n];
		diag0 = new boolean[2 * n - 1];
		diag1 = new boolean[2 * n - 1];
		bt(0);
		return result;
	}

	private void bt(int r) {
		if (r == len) {
			result++;
			return;
		};
		for (int j = 0; j < len; j++) {
			if (isvalid(r, j)) {
				set(r, j, true);
				bt(r + 1);
				set(r, j, false);
			}
		}
	}

	private void set(int i, int j, boolean f) {
			cols[j] = f;
			diag0[rctoDiag(0, i, j)] = f;
			diag1[rctoDiag(1, i, j)] = f;
	}

	private boolean isvalid(int i, int j) {
		return !(cols[j] == true || diag0[rctoDiag(0, i, j)] == true || diag1[rctoDiag(1, i, j)] == true);
	}

	private int rctoDiag(int index, int r, int c) {
		if (index == 0) {
			return (r - c >= 0) ? r - c: 2 * len - 1 + (r - c);
		}
		if (index == 1) {
			return r + c;
		}
		else throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.totalNQueens(6));
	}
}