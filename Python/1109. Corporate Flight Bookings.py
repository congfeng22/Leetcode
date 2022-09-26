def corpFlightBookings(bookings, n):
    gaps = [0]*(n+1)
    for f,l,s in bookings:
        gaps[f-1] += s
        gaps[l] -= s
    for i in range(1,len(gaps)-1):
        gaps[i] = gaps[i] + gaps[i-1]
    gaps.pop()
    return gaps