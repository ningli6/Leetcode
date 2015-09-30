class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.next = [None for x in range(26)]
        self.isWord = False

class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        cur = self.root
        for c in word:
            if not cur.next[ord(c) - 97]:
                cur.next[ord(c) - 97] = TrieNode()
            cur = cur.next[ord(c) - 97]
        cur.isWord = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        cur = self.root
        for c in word:
            cur = cur.next[ord(c) - 97]
            if not cur:
                return False
        return cur.isWord

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        cur = self.root
        for c in prefix:
            cur = cur.next[ord(c) - 97]
            if not cur:
                return False
        if cur.isWord:
            return True
        for child in cur.next:
            if child:
                return True
        return False

# Your Trie object will be instantiated and called as such:
trie = Trie()
trie.insert("a")
# print trie.search("a")
print trie.startsWith("a")
# trie.insert("abc")
# print trie.search(list("abc"))