from collections import deque


def asteroidCollision(asteroids):
    q = deque()
    ret = []
    for asteroid in asteroids:
        destroyed = False
        if asteroid < 0:
            while q:
                goingright = q[-1]
                if goingright > abs(asteroid):
                    destroyed = True
                    break
                elif goingright == abs(asteroid):
                    q.pop()
                    destroyed = True
                    break
                else:
                    q.pop()
            if not q and not destroyed:
                ret.append(asteroid)
        elif asteroid > 0:
            q.append(asteroid)
    for asteroid in q:
        ret.append(asteroid)
    return ret