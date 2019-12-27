class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        done = False
        valid = True
        for arow in board:
            rowdict = {}
            for entry in arow:
                if entry != ".":
                    if rowdict.get(entry,0)==1:
                        done = True
                        valid = False
                        break
                    rowdict[entry] = 1
            if done:
                break
        if not done:
            for i in range(9):
                acol = [row[i] for row in board]
                coldict = {}
                for entry in acol:
                    if entry != ".":
                        if coldict.get(entry,0)==1:
                            done = True
                            valid = False
                            break
                        coldict[entry] = 1
                if done:
                    break
        if not done:
            for i in range(3):
                for j in range(3):
                    box = [entry for rows in board[3*i:3*i+3] for entry in rows[3*j:3*j+3]]
                    boxdict = {}
                    for entry in box:
                        if entry != ".":
                            if boxdict.get(entry,0)==1:
                                done = True
                                valid = False
                                break
                            boxdict[entry] = 1
                    if done:
                        break
                if done:
                    break
        return valid

test = Solution()
sample = [
        [".",".","4",".",".",".","6","3","."],
        [".",".",".",".",".",".",".",".","."],
        ["5",".",".",".",".",".",".","9","."],
        [".",".",".","5","6",".",".",".","."],
        ["4",".","3",".",".",".",".",".","1"],
        [".",".",".","7",".",".",".",".","."],
        [".",".",".","5",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."]
        ]
print(test.isValidSudoku(sample))