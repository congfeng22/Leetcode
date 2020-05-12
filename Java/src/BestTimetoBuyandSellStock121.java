public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int minidx = 0;
        int profit = 0;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<prices[minidx]) minidx = i;
            else if (prices[i]>prices[minidx]) profit = Math.max(profit,prices[i]-prices[minidx]);
        }
        return profit;
    }
}
