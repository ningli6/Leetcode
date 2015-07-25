public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int count = 0; /* ptr for char in word */
        boolean hit =false;
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			if (word.length() == 1) return true;
        			hit = searchBoard(board, isVisited, word, 0, i, j);
        			if (hit) return hit;
        		}
        	}
        }
        return hit;
    }

    private boolean searchBoard(char[][] board, boolean[][] isVisited, String word, int ptr, int r, int c) {
    	isVisited[r][c] = true;
    	ptr++;
    	int rows = board.length;
        int cols = board[0].length;
    	char search = word.charAt(ptr);
    	boolean ret =false;
    	if (isIndexValid(c - 1, cols) && board[r][c - 1] == search && isVisited[r][c - 1] == false) {
    		if (ptr == word.length() - 1) return true;
    		ret = searchBoard(board, isVisited, word, ptr, r, c - 1);
    		if (ret) return ret;
    	}
    	if (isIndexValid(c + 1, cols) && board[r][c + 1] == search && isVisited[r][c + 1] == false) {
    		if (ptr == word.length() - 1) return true;
    		ret = searchBoard(board, isVisited, word, ptr, r, c + 1);
    		if (ret) return ret;
    	}
    	if (isIndexValid(r - 1, rows) && board[r - 1][c] == search && isVisited[r - 1][c] == false) {
    		if (ptr == word.length() - 1) return true;
    		ret = searchBoard(board, isVisited, word, ptr, r - 1, c);
    		if (ret) return ret;
    	}
    	if (isIndexValid(r + 1, rows) && board[r + 1][c] == search && isVisited[r + 1][c] == false) {
    		if (ptr == word.length() - 1) return true;
    		ret = searchBoard(board, isVisited, word, ptr, r + 1, c);
    		if (ret) return ret;
    	}
    	isVisited[r][c] = false;
    	return ret;
    }

    private boolean isIndexValid(int index, int bound) {
    	return (index < bound) && (index >= 0);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	char[][] board = {
    		{'A', 'B', 'C', 'E'},
    		{'S', 'F', 'C', 'S'},
    		{'A', 'D', 'E', 'E'}
    	};
    	System.out.println(sol.exist(board, "ABCCED"));
    	System.out.println(sol.exist(board, "SEE"));
    	System.out.println(sol.exist(board, "ABCB"));
    }
}