class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.next = [None for x in range(26)]

class WordDictionary(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.root = TrieNode()        

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        if not word:
            return
        word = word.lower()
        cur = self.root
        for c in word:
            if not cur.next[ord(c) - 97]:
                cur.next[ord(c) - 97] = TrieNode()
            cur = cur.next[ord(c) - 97]
        cur.isWord = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        if not word:
            return False
        word = word.lower()
        return self.searchNode(word, self.root)

    def searchNode(self, word, node):
        if not node:
            return False
        if not word:
            return node.isWord
        c = word[0]
        if c == '.':
            for n in node.next:
                if self.searchNode(word[1:], n):
                    return True
            return False
        return self.searchNode(word[1:], node.next[ord(c) - 97])

# Your WordDictionary object will be instantiated and called as such:
wordDictionary = WordDictionary()
wordDictionary.addWord("word")
wordDictionary.addWord("good")
print wordDictionary.search("w")
print wordDictionary.search("goo")
print wordDictionary.search("good")
print wordDictionary.search("goodd")