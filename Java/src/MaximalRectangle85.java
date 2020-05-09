public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0) return 0;
        // dp[i][j] = highest tower of 1's from that entry, including that entry
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i]=='0'?0:1;
            System.out.println(dp[0][i]);
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                dp[i][j] = matrix[i][j]=='0'?0:dp[i-1][j]+1;
            }
        }
        // dp[i][j] = max area of rectangle of 1's including that whole entry
        int max = 0;
        for (int i=0;i<matrix.length;i++){
            int[] lessfromLeft = new int[matrix[0].length];
            lessfromLeft[0]=-1;
            int[] lessfromRight = new int[matrix[0].length];
            lessfromRight[matrix[0].length-1] = matrix[0].length;
            for (int j=1;j<matrix[0].length;j++){
                int p = j-1;
                while (p>=0 && dp[i][p]>=dp[i][j]) p = lessfromLeft[p];
                lessfromLeft[j]=p;
            }
            for (int j=matrix[0].length-2;j>=0;j--){
                int p = j+1;
                while (p<matrix[0].length && dp[i][p]>=dp[i][j]) p = lessfromRight[p];
                lessfromRight[j]=p;
            }
            for (int j=0;j<matrix[0].length;j++){
                if (dp[i][j] == 0) continue;
                max = Math.max(dp[i][j]*(lessfromRight[j]-lessfromLeft[j]-1),max);
            }
        }
        return max;
    }
    public static void main(String[] args){
        MaximalRectangle85 test = new MaximalRectangle85();
        char t[][] = {
                {'0','1'}
        };
        System.out.println(test.maximalRectangle(t));
    }
}
