import java.util.Arrays;

public class BestTimetoBuyandSellStockIII123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // one[i] = max profit with 1 transaction within 0-th day to i-th day
        int[] one = new int[n];
        int minidx = 0;
        int profit = 0;
        one[0]=0;
        for (int i=1;i<n;i++){
            if (prices[i]<prices[minidx]){
                minidx = i;
                one[i]=one[i-1];
            }
            else {
                profit = Math.max(profit,prices[i]-prices[minidx]);
                one[i] = profit;
            }
        }
        // two[i] = max profit with 1 transaction within i-th day to (n-1)-th day
        int[] two = new int[n];
        int maxidx = n-1;
        profit = 0;
        two[n-1]=0;
        for (int i=n-2;i>=0;i--){
            if (prices[i]>prices[maxidx]){
                maxidx = i;
                two[i]=two[i+1];
            }
            else {
                profit = Math.max(profit,prices[maxidx]-prices[i]);
                two[i] = profit;
            }
        }
        for (int i=0;i<n;i++){
            profit = Math.max(profit,one[i]+two[i]);
        }
        return profit;
    }
    public static void main(String[] args){
        BestTimetoBuyandSellStockIII123 test = new BestTimetoBuyandSellStockIII123();
        int[] t = {3,3,5,0,0,3,1,4};
        System.out.println(test.maxProfit(t));
    }
}
