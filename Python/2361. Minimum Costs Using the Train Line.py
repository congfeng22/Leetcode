def minimumCosts(regular, express, expressCost):
    regcost = [0]*(len(regular)+1)
    expcost = [0]*(len(regular)+1)
    expcost[0] = expressCost
    for i in range(1,len(regcost)):
        regcost[i], expcost[i] = min(regcost[i-1]+regular[i-1], expcost[i-1]+express[i-1]), min(expcost[i-1]+express[i-1], regcost[i-1]+regular[i-1] + expressCost)
    return [min(regcost[i],expcost[i]) for i in range(1,len(regcost))]