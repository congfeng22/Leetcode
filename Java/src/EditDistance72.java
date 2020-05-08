public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        // dp[i][j] = minDistance between first i characters of word1 and first j characters of word2
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i=0;i<word1.length()+1;i++){
            dp[i][0] = i;
        }
        for (int j=0;j<word2.length()+1;j++){
            dp[0][j] = j;
        }
        for (int i=1;i<word1.length()+1;i++){
            for (int j=1;j<word2.length()+1;j++){
                // Replace last char
                int min = dp[i-1][j-1]+1;
                // Add last char to word1
                min = Math.min(min,dp[i-1][j]+1);
                // Add last char to word2
                min = Math.min(min,dp[i][j-1]+1);
                // If last char of each word are equal
                if (word1.charAt(i-1)==word2.charAt(j-1)) min = Math.min(min,dp[i-1][j-1]);
                dp[i][j] = min;
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String[] args){
        EditDistance72 test = new EditDistance72();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(test.minDistance(word1,word2));
    }
}
