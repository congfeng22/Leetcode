from collections import deque
def openLock(deadends, target):
    adj = [[1,9],[2,0],[3,1],[4,2],[5,3],[6,4],[7,5],[8,6],[9,7],[0,8]]
    deadends = set(deadends)
    if '0000' in deadends:
        return -1
    visited = set()
    q = deque()
    q.append('0000')
    moves = 0
    while q:
        length = len(q)
        for i in range(length):
            curr = q[0]
            q.popleft()
            if curr == target:
                return moves
            visited.add(curr)
            for idx in range(4):
                for replacement in adj[int(curr[idx])]:
                    nei = curr[:idx] + str(replacement) + curr[idx+1:]
                    if nei in deadends:
                        continue
                    if nei not in visited:
                        q.append(nei)
                        visited.add(nei)
        moves += 1
    return -1;