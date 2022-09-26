from collections import deque
def shortestPathBinaryMatrix(grid):
    m,n = len(grid), len(grid[0])
    if grid[0][0] == 1 or grid[m-1][n-1] == 1:
        return -1
    ret = 1
    q = deque()
    q.append((0,0))
    def valid(i,j):
        return i>=0 and i < m and j >= 0 and j < n and grid[i][j] == 0 and (i,j) not in visited
    visited = set([(0,0)])
    while q:
        #print(visited, ret, q)
        length = len(q)
        for k in range(length):
            curr = q[0]
            #print(curr)
            q.popleft()
            if curr == (m-1,n-1):
                return ret
            for i in range(3):
                for j in range(3):
                    if i == 1 and j == 1:
                        continue
                    if valid(curr[0]+i-1, curr[1]+j-1):
                        visited.add((curr[0]+i-1,curr[1]+j-1))
                        q.append((curr[0]+i-1,curr[1]+j-1))
        ret += 1
    return -1