def lastRemaining(n):
    if n == 1:
        return 1
    power, mod, nums = 1, 0, n//2
    while nums>1:
        if mod == 0 and power%2 == 1 and nums%2 == 0:
            mod += 2**power
        elif mod != 0 and (power%2 == 0 or (power%2 == 1 and nums%2 == 1)):
            mod += 2**power
        power += 1
        nums = nums//2
    return mod if mod != 0 else 2**power