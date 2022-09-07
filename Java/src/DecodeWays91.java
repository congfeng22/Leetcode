import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class DecodeWays91 {
    public int numDecodings(String s) {
        // dp[i] = number of ways to decode the first i characters of s
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        if (s.charAt(0)=='0') return 0;
        dp[1]=1;
        for (int i=2;i<s.length()+1;i++){
            if (s.charAt(i-1)=='0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') return 0;
                else dp[i] = dp[i - 2];
            } else dp[i] = dp[i-1]+ ((s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<='6'))?dp[i-2]:0);
        }
        return dp[s.length()];
    }
}