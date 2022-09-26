class TrieNode:
    def __init__(self, value = None):
        self.val = value
        self.children = [None]*26
        self.isWord = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        currnode = self.root
        for c in word:
            if currnode.children[ord(c)-ord('a')] == None:
                currnode.children[ord(c)-ord('a')] = TrieNode(c)
            currnode = currnode.children[ord(c)-ord('a')]
        currnode.isWord = True

    def search(self, word: str) -> bool:
        currnode = self.root
        for c in word:
            if currnode.children[ord(c)-ord('a')] == None:
                return False
            currnode = currnode.children[ord(c)-ord('a')]
        return currnode.isWord
        

    def startsWith(self, prefix: str) -> bool:
        currnode = self.root
        for c in prefix:
            if currnode.children[ord(c)-ord('a')] == None:
                return False
            currnode = currnode.children[ord(c)-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)