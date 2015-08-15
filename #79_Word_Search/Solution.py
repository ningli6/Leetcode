class Solution:
    # @param {character[][]} board
    # @param {string} word
    # @return {boolean}
    def exist(self, board, word):
        if not board and not word:
        	return True
        if not board:
        	return False
        if not word:
        	return True
        for i in range(len(board)):
        	for j in range(len(board[0])):
        		if board[i][j] == word[0]:
        			if self.search(board, word, i, j):
        				return True
        return False

    def search(self, board, word, i, j):
    	if board[i][j] != word[0]:
    		return False
    	if len(word) == 1:
    		return True
    	board[i][j] = '0'
    	if i > 0 and board[i - 1][j] != '0' and self.search(board, word[1:], i - 1, j):
    		return True
    	if i < len(board) - 1 and board[i + 1][j] != '0' and self.search(board, word[1:], i + 1, j):
    		return True
    	if j > 0 and board[i][j - 1] != '0' and self.search(board, word[1:], i, j - 1):
    		return True
    	if j < len(board[0]) - 1 and board[i][j + 1] != '0' and self.search(board, word[1:], i, j + 1):
    		return True
    	board[i][j] = word[0]
    	return False

sol = Solution()
t = [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']]
print sol.exist(t, "ABCB")