def maxProfit(prices, fee):
    flat = 0
    long = -prices[0]
    for i in range(1,len(prices)):
        flat, long = max(flat, long + prices[i] - fee), max(long, flat - prices[i])
    return flat
    