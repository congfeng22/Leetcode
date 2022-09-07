# def countPyramids(self, G):
#     m, n, ans = len(G), len(G[0]), 0
    
#     @lru_cache(None)
#     def dp(i, j, dr):
#         if G[i][j] == 1 and 0 <= i + dr < m and j > 0 and j + 1 < n and G[i+dr][j] == 1:
#             return min(dp(i+dr, j-1, dr), dp(i+dr, j+1, dr)) + 1
#         return G[i][j]
    
#     for i, j in product(range(m), range(n)):
#         ans += max(0, dp(i, j, 1) - 1)
#         ans += max(0, dp(i, j, -1) - 1)
    
#     return ans

def countPyramids(grid):
    cacheUp = {}
    cacheDown = {}
    # cache[(r,c)] = h
    ret1 = 0
    ret2 = 0
    def maxHeightUp(grid, r, c, h):
        # get max height of a pyramid with apex at row r and col c, knowing that it's at least height h
        if r+h < len(grid) and c-h>=0 and c+h<len(grid[0]):
            for i in range(c-h, c+h+1):
                if not grid[r+h][i]:
                    return h
            return maxHeightUp(grid, r, c, h+1)
        return h
    
    for r in range(len(grid)):
        for c in range(len(grid[0])):
            if not grid[r][c]:
                continue
            height = maxHeightUp(grid, r, c, cacheUp.get((r,c),1))
            if height == 1:
                continue
            for h in range(1,height):
                for b in range(-h+1, h):
                    cacheUp[(r+h-1,c+b)] = height-h+1
                    cacheDown[(r+h-1,c+b)] = min(b-h+1, h-1-b)//2+1
    ret1 = sum(cacheUp.values())-len(cacheUp)

    def maxHeightDown(grid, r, c, h):
        # get max height of an inverted pyramid with apex at row r and col c, knowing that it's at least height h
        if r-h >=0 and c-h>=0 and c+h<len(grid[0]):
            for i in range(c-h, c+h+1):
                if not grid[r-h][i]:
                    return h
            return maxHeightDown(grid, r, c, h+1)
        return h
    
    for r in range(len(grid)-1,-1,-1):
        for c in range(len(grid[0])):
            if not grid[r][c]:
                continue
            height = maxHeightDown(grid, r, c, cacheDown.get((r,c),1))
            if height == 1:
                continue
            for h in range(1,height):
                for b in range(-h+1, h):
                    cacheDown[(r-h+1,c+b)] = height-h+1
    ret2 = sum(cacheDown.values())-len(cacheDown)

    return ret1+ret2

print(countPyramids([[0,1,1,1,0],
                     [1,1,1,1,1],
                     [1,1,1,1,1],
                     [1,0,1,0,1]]))