class TrieNode {
    public TrieNode[] children;
    public boolean isString;
    // Initialize your data structure here.
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

public class Trie {
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

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");