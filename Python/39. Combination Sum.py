def combinationSum(candidates, target):
    ret = []
    def backtracking(candidates, i, path, target):
        #print(i, path, target)
        if target == 0:
            ret.append(list(path))
            return
        if i >= len(candidates):
            return
        if target >= candidates[i]:
            path.append(candidates[i])
            
            backtracking(candidates, i, path, target-candidates[i])
            path.pop()

        backtracking(candidates, i+1, path, target)
    backtracking(candidates, 0, [], target)
    return ret