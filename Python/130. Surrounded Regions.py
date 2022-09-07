def solve(board):
    """
    Do not return anything, modify board in-place instead.
    """
    visited = set()
    def cannotCapture(board, i, j):
        if (i,j) in visited:
            return
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return
        if board[i][j] == "X":
            return
        visited.add((i,j))
        cannotCapture(board,i+1,j)
        cannotCapture(board,i-1,j)
        cannotCapture(board,i,j+1)
        cannotCapture(board,i,j-1)
        return
    
    for i in range(len(board)):
        for j in range(len(board[0])):
            if i==0 or j==0 or i==len(board)-1 or j==len(board[0])-1:
                cannotCapture(board,i,j)
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == "O" and (i,j) not in visited:
                board[i][j] = "X"
    #print(visited)
    return board