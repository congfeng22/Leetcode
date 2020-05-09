public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        int max =  0;
        int[] dp = new int[heights.length];
        for (int i=0;i<heights.length;i++){
            dp[i] = heights[i];
            max = Math.max(max,dp[i]);
            for (int j=i+1;j<heights.length;j++){
                dp[j] = Math.min(dp[j-1],heights[j]);
                max = Math.max(max,dp[j]*(j-i+1));
            }
        }
        return max;
    }
    public static void main(String[] args){
        LargestRectangleinHistogram84 test = new LargestRectangleinHistogram84();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(test.largestRectangleArea(heights));
    }
}
