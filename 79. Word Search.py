class Solution(object):
    def neighbors(self,board,entrytup):
        neighbor = []
        if entrytup[0]!=0:
            neighbor.append((entrytup[0]-1,entrytup[1]))
        if entrytup[0]!=len(board)-1:
            neighbor.append((entrytup[0]+1,entrytup[1]))
        if entrytup[1]!=0:
            neighbor.append((entrytup[0],entrytup[1]-1))
        if entrytup[1]!=len(board[0])-1:
            neighbor.append((entrytup[0],entrytup[1]+1))
        return neighbor
            
            
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        for row in range(len(board)):
            for letter in range(len(board[0])):
                if board[row][letter] == word[0]:
                    forbiddened = [(row,letter)]
                    triedbefore = []
                    depth=1
                    while depth<len(word):
                        children = Solution.neighbors(self,board,forbiddened[-1])
                        found = False
                        for breadth in children:
                            if word[depth] == board[breadth[0]][breadth[1]] and breadth not in forbiddened:
                                forbiddened.append(breadth)
                                if forbiddened not in triedbefore:
                                    depth+=1
                                    found = True
                                    break
                                else:
                                    del forbiddened[-1]
                        if not found:
                            triedbefore.append(forbiddened.copy())
                            del forbiddened[-1]
                            depth -= 1
                        if forbiddened == []:
                            break
                    if depth == len(word):
                        return True
        return False
test = Solution()
print(test.exist([['A','B','C','E'],['S','F','C','S'],['A','D','E','E']],"ABCB"))