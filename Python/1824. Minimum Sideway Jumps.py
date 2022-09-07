def minSideJumps(obstacles):
    idx, lane, jumps = 0,2,0
    while idx < len(obstacles)-1:
        if obstacles[idx+1]!=lane:
            idx += 1
        else:
            jumps+=1
            newlane1 = (lane)%3 + 1
            newlane2 = (lane+1)%3 + 1
            if obstacles[idx] == newlane1:
                lane = newlane2
            elif obstacles[idx] == newlane2:
                lane = newlane1
            else:
                while idx < len(obstacles)-1 and obstacles[idx+1]!=newlane1 and obstacles[idx+1]!=newlane2:
                    idx += 1
                if idx == len(obstacles)-1:
                    return jumps
                if obstacles[idx+1]==newlane1:
                    lane = newlane2
                else:
                    lane = newlane1
    return jumps