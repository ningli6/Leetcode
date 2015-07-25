public class WordDictionary {
	static int R = 26;
	class Node {
		char c;
		Node[] children;
		boolean word;

		Node(char c) {
			this.c = c;
			children = new Node[R];
		}
	}

	Node root = new Node('r');

    // Adds a word into the data structure.
    public void addWord(String word) {
    	if (word == null || word.length() == 0) return;
    	String str = word.toLowerCase();
    	Node cur = root;
    	for (int i = 0; i < str.length(); i++) {
    		int c = str.charAt(i) - 'a';
    		if (cur.children[c] == null) cur.children[c] = new Node(str.charAt(i));
    		cur = cur.children[c];
    	}
    	cur.word = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        String str = word.toLowerCase();
        return search(root, 0, str);
    }

    private boolean search(Node node, int index, String str) {
    	if (node == null) return false;
    	if (index == str.length()) {
    		return node.word;
    	}
    	char c = str.charAt(index);
    	if (c == '.') {
    		for (int i = 0; i < R; i++) {
    			if (node.children[i] == null) continue;
    			if (search(node.children[i], index + 1, str)) return true;
    		}
    		return false;
    	}
    	int num = c - 'a';
    	return search(node.children[num], index + 1, str);
    }

    public static void main(String[] args) {
    	WordDictionary dict = new WordDictionary();
    	dict.addWord("at");
    	dict.addWord("and");
    	dict.addWord("an");
    	dict.addWord("add");
    	System.out.println(dict.search("a"));
    	System.out.println(dict.search(".at"));
    	System.out.println(dict.search("bat"));
    	System.out.println(dict.search(".at"));
    	System.out.println(dict.search("an."));
    	System.out.println(dict.search("a.d."));
    	System.out.println(dict.search("b."));
    	System.out.println(dict.search("a.d"));
    	System.out.println(dict.search("."));
    }
}