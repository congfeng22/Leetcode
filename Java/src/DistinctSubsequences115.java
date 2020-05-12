public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        if (s.length()<t.length()) return 0;
        if (s.length()==0 || t.length()==0) return 0;
        // dp[i][j] = distinct subsequences in up to i-th index of s, equals to up to j-th index of t
        int[][] dp = new int[s.length()][t.length()];
        if (s.charAt(0)==t.charAt(0)) dp[0][0] = 1;
        for (int i=1;i<s.length();i++){
            dp[i][0] = dp[i-1][0] + ((s.charAt(i)==t.charAt(0))?1:0);
        }
        for (int i=1;i<s.length();i++){
            for (int j=1;j<t.length();j++){
                if (j>i) break;
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i)==t.charAt(j)) dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[s.length()-1][t.length()-1];
    }
}
