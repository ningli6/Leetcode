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

class Solution(object):

    def __init__(self):
        self.re = None
        self.dict = None

    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        if not board or not words:
            return []
        self.re = []
        self.dict = Trie()
        for w in words:
            self.dict.insert(w)
        isVisted = [[False for j in range(len(words[0]))] for i in range(len(words))]
        tmp = []
        for i in range(len(words)):
            for j in range(len(words[0])):
                self.search(i, j, board, isVisted, tmp) # isVisted and tmp should be cleared each time
        return self.re

    def search(self, i, j, board, isVisted, tmp):
        if i < 0 or i >= len(board):
            return
        if j < 0 or j >= len(board[0]):
            return
        if isVisted[i][j]:
            return
        isVisted[i][j] = True
        tmp.append(board[i][j])
        if self.dict.search(tmp):
            self.re.append(''.join(tmp))
        if self.dict.startsWith(tmp):
            self.search(i - 1, j, board, isVisted, tmp)
            self.search(i + 1, j, board, isVisted, tmp)
            self.search(i, j - 1, board, isVisted, tmp)
            self.search(i, j + 1, board, isVisted, tmp)
        tmp.pop()
        isVisted[i][j] = False

sol = Solution()
# t = [
#   ['o','a','a','n'],
#   ['e','t','a','e'],
#   ['i','h','k','r'],
#   ['i','f','l','v']
# ]
# w = ["oath","pea","eat","rain"]
print sol.findWords(["a"], ["aa"])