public class WildcardMatching44 {
    public boolean isMatch(String s, String p) {
        // dp[i][j] = whether first i and j characters in s and p match
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // set up base case
        dp[0][0] = true;
        for (int j=1;j<p.length()+1;j++){
            if (p.charAt(j-1)=='*') dp[0][j] = dp[0][j-1];
        }
        for (int i=1;i<s.length()+1;i++){
            for (int j=1;j<p.length()+1;j++){
                char schar = s.charAt(i-1);
                char pchar = p.charAt(j-1);
                if (schar == pchar || pchar == '?') dp[i][j] = dp[i-1][j-1];
                else if (pchar == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
