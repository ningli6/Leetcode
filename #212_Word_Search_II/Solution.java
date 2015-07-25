import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<String>();
        if (words.length == 0) return result;
        if (board == null) return result;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] prefix = new boolean[rows][cols];
        Trie trie = new Trie();
        HashSet<String> set = new HashSet<String>();
        for (String w : words) trie.insert(w);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                StringBuilder sb = new StringBuilder();
                boolean[][] isMarked = new boolean[rows][cols];
                search(trie, set, board, result, isMarked, sb, i, j);
            }
        }
        return result;
    }

    private void search(Trie trie, HashSet<String> set, char[][] board, List<String> result, boolean[][] isMarked, StringBuilder sb, int r, int c) {
        isMarked[r][c] = true;
        sb.append(board[r][c]);
        int rows = board.length;
        int cols = board[0].length;
        String nsb = sb.toString();
        if (trie.startsWith(nsb)) {
            if (trie.search(nsb)) {
                if (!set.contains(nsb)) {
                    result.add(nsb);
                    set.add(nsb);
                }
            }
            if (isValid(rows, cols, r - 1, c) && !isMarked[r - 1][c]) search(trie, set, board, result, isMarked, sb, r - 1, c);
            if (isValid(rows, cols, r + 1, c) && !isMarked[r + 1][c]) search(trie, set, board, result, isMarked, sb, r + 1, c);
            if (isValid(rows, cols, r, c - 1) && !isMarked[r][c - 1]) search(trie, set, board, result, isMarked, sb, r, c - 1);
            if (isValid(rows, cols, r, c + 1) && !isMarked[r][c + 1]) search(trie, set, board, result, isMarked, sb, r, c + 1);
        }
        isMarked[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isValid(int rows, int cols, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] test = {"oath","pea","eat","rain"};
        char[][] board = {
              {'o','a','a','n'},
              {'e','t','a','e'},
              {'i','h','k','r'},
              {'i','f','l','v'}
        };
        List<String> list = sol.findWords(board, test);
        for (String s: list) {
            System.out.println(s);
        }
    }
}

class TrieNode {
    public TrieNode[] children;
    public boolean isString;
    // Initialize your data structure here.
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len = word.length();
        TrieNode rt = this.root;
        for (int i = 0; i < len; i++) {
            if (rt.children[word.charAt(i) - 'a'] == null) rt.children[word.charAt(i) - 'a'] = new TrieNode();
            rt = rt.children[word.charAt(i) - 'a'];
        }
        rt.isString = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length();
        TrieNode rt = this.root;
        for (int i = 0; i < len; i++) {
            if (rt.children[word.charAt(i) - 'a'] == null) return false;
            rt = rt.children[word.charAt(i) - 'a'];
        }
        return rt.isString;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode rt = this.root;
        for (int i = 0; i < len; i++) {
            if (rt.children[prefix.charAt(i) - 'a'] == null) return false;
            rt = rt.children[prefix.charAt(i) - 'a'];
        }
        if (rt.isString) return true;
        for (int i = 0; i < 26; i++) {
            if (rt.children[i] != null) return true;
        }
        return false;
    }
}